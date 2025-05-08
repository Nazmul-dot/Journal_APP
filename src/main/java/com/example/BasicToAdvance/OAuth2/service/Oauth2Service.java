package com.example.BasicToAdvance.OAuth2.service;


import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import com.example.BasicToAdvance.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@Service
public class Oauth2Service {


    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.secret}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;


    public String authentication(String code){


        try{
            System.out.println(clientId);
            System.out.println(clientSecret);
            String tokenEndpoint = "https://oauth2.googleapis.com/token";
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("code", code);
            params.add("client_id", clientId);
            params.add("client_secret", clientSecret);
            params.add("redirect_uri", "http://localhost:3000/getAuth/google");
            params.add("grant_type", "authorization_code");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
            ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(tokenEndpoint, request, Map.class);
            String idToken = (String) tokenResponse.getBody().get("id_token");
            String userInfoUrl = "https://oauth2.googleapis.com/tokeninfo?id_token=" + idToken;
            ResponseEntity<Map> userInfoResponse = restTemplate.getForEntity(userInfoUrl, Map.class);
            System.out.println(userInfoResponse.getBody());

            if(userInfoResponse.getStatusCode()==HttpStatus.OK){

              Map<String, Object> userInfoMap = (Map<String, Object>) userInfoResponse.getBody();
              String email = (String) userInfoMap.get("email");
              UserDetails userDetails=null;

              try{
                  userDetails = userDetailsService.loadUserByUsername(email);
                  System.out.println("user already exist");
              } catch (Exception e) {
                  UserSchema userSchema = new UserSchema();
                  userSchema.setEmail(email);
                  userSchema.setName(userInfoMap.get("name").toString());
                  userSchema.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
                  userRepository.save(userSchema);
                  System.out.println("user successfully created");
              }

                 userDetails = userDetailsService.loadUserByUsername(email);
                 String token = jwtTokenUtil.generateToken(userDetails);
                 return token;

            }
            else{
                throw new RuntimeException("Failed to get user info");
            }

        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

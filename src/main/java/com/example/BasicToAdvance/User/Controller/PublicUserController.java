package com.example.BasicToAdvance.User.Controller;

import com.example.BasicToAdvance.User.Service.CustomUserDetailsService;
import com.example.BasicToAdvance.User.Service.UserServices;
import com.example.BasicToAdvance.User.UserDto.User;
import com.example.BasicToAdvance.User.UserDto.UserResponse;
import com.example.BasicToAdvance.contraint.CommonApi;
import com.example.BasicToAdvance.utils.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(CommonApi.BASE_URL + "/auth/user")
public class PublicUserController {
    private final UserServices userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final CustomUserDetailsService userDetailsService;

    public PublicUserController(UserServices userService,
                                AuthenticationManager authenticationManager,
                                JwtTokenUtil jwtTokenUtil,
                                CustomUserDetailsService userDetailsService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> UserRegistration(@RequestBody User user) {
        try {
            UserResponse savedUser = userService.addUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // 201 Created
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // 409 Conflict if user already exists
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> UserLogin(@RequestBody User user) {
        try {
            // Authenticate user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword())
            );

            // Generate token
            final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(Map.of("token", token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // JWT is stateless, so logout is handled client-side by discarding the token
        return ResponseEntity.ok("Logged out successfully");
    }
}


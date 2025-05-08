package com.example.BasicToAdvance.OAuth2.controller;

import com.example.BasicToAdvance.OAuth2.service.Oauth2Service;
import com.example.BasicToAdvance.contraint.CommonApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(CommonApi.BASE_URL + "/oauth2")
public class oauth2Controller {

    private final Oauth2Service oauth2Service;

    public oauth2Controller(Oauth2Service oauth2Service) {
        this.oauth2Service = oauth2Service;
    }


    @PostMapping("/callback")
    public ResponseEntity<?> oauth2Authentication(@RequestBody Map<String, String> body){

     String accessToken = oauth2Service.authentication(body.get("code"));
     return ResponseEntity.ok(Map.of("access_token", accessToken));

    }
}

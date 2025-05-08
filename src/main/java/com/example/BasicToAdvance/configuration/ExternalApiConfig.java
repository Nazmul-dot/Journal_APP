package com.example.BasicToAdvance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalApiConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.example.BasicToAdvance.kafka.controller;

import com.example.BasicToAdvance.contraint.CommonApi;
import com.example.BasicToAdvance.kafka.model.MailBody;
import com.example.BasicToAdvance.kafka.service.producerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CommonApi.BASE_URL + "/kafka")
@Slf4j
public class kafkaController {

    private final producerService producerService;

    public kafkaController(producerService producerService) {
        this.producerService = producerService;
    }
    @PostMapping
    public ResponseEntity<?> kafka( @RequestBody MailBody mailBody) {
        producerService.sendMessage(mailBody);
        log.info("kafka");
        return ResponseEntity.ok("kafka");
    }
}

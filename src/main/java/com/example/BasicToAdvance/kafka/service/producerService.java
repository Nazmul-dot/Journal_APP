package com.example.BasicToAdvance.kafka.service;

import com.example.BasicToAdvance.kafka.model.MailBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class producerService {

    private final KafkaTemplate<String, MailBody> kafkaTemplate;  // Changed to MailBody
    public producerService(KafkaTemplate<String, MailBody> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MailBody mailBody){
        kafkaTemplate.send("send-mail", mailBody.getTo(), mailBody);

    }
}

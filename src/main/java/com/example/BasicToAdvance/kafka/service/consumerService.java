//package com.example.BasicToAdvance.kafka.service;
//
//import com.example.BasicToAdvance.kafka.model.MailBody;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class consumerService {
//
//    @KafkaListener(id = "group1", topics = "send-mail", containerFactory = "mailBodyKafkaListenerContainerFactory")
//    public void consume(MailBody mailBody) {
//        System.out.println("Received message: " + mailBody.getTo());
//        System.out.println("Received message: " + mailBody.getSubject());
//        System.out.println("Received message: " + mailBody.getBody());
//    }
//}

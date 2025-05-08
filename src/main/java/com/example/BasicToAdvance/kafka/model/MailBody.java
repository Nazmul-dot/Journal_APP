package com.example.BasicToAdvance.kafka.model;

import lombok.*;
@Builder

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailBody {
    private String to;
    private String subject;
    private String body;
}

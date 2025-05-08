package com.example.BasicToAdvance.Jarnal.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jarnal {
    private UUID id;
    private String content;
    private String title;
    private String email;
}

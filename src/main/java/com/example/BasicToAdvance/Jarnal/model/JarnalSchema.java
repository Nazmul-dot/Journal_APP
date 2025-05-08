package com.example.BasicToAdvance.Jarnal.model;


import com.example.BasicToAdvance.Jarnal.Dto.Jarnal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_jarnal")
public class JarnalSchema {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "creatorId")
    private String email;

    public JarnalSchema(Jarnal jarnal) {

        this.title = jarnal.getTitle();
        this.content = jarnal.getContent();
        this.email = jarnal.getEmail();
    }

}

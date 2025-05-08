package com.example.BasicToAdvance.Jarnal.Dto;

import com.example.BasicToAdvance.Jarnal.model.JarnalSchema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JarnalResponse {
    private UUID id;
    private String content;
    private String title;

    public JarnalResponse(JarnalSchema jarnalSchema) {
        this.id = jarnalSchema.getId();
        this.content = jarnalSchema.getContent();
        this.title = jarnalSchema.getTitle();
    }

    public List<JarnalResponse> toJarnalResponses(List<JarnalSchema> jarnalSchemas) {
        List<JarnalResponse> JarnalResponses = new ArrayList<>();
        for(JarnalSchema jarnalSchema : jarnalSchemas) {
            JarnalResponses.add(new JarnalResponse(jarnalSchema));
        }
        return JarnalResponses;
    }
}

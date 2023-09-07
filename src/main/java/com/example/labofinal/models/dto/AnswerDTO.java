package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.Answer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {


    private String title;
    public static AnswerDTO toDTO(Answer entity){
        if(entity == null)
            return null;

        return AnswerDTO.builder()
                .title(entity.getTitle())
                .build();
    }
}

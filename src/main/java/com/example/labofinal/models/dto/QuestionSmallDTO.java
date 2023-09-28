package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class QuestionSmallDTO {

    private String title;
    private String explication;
    private List<AnswerDTO> answers;
    private AnswerDTO goodAnswer;

    public static QuestionSmallDTO toDTO(Question entity){
        if(entity == null)
            return null;

        return QuestionSmallDTO.builder()
                .title(entity.getTitle())
                .explication(entity.getExplication())
                .answers(entity.getAnswers().stream().map(AnswerDTO::toDTO).toList())
                .build();
    }

}

package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class QuestionDTO {

    private Long id;
    private String title;
    private String explication;
    private Set<AnswerDTO> answers;
    private AnswerDTO goodAnswer;
    private String creator;

    public static QuestionDTO toDTO(Question entity){
        if(entity == null)
            return null;

        return QuestionDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .explication(entity.getExplication())
                .answers(entity.getAnswers().stream().map(AnswerDTO::toDTO).collect(Collectors.toSet()))
                .creator(entity.getCreator().getUsername())
                .build();
    }

}

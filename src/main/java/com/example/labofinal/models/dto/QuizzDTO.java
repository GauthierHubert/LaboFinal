package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class QuizzDTO {
    private Long id;
    private LocalDate date;
    private Integer goodAnswer;
    private List<QuestionSmallDTO> questionList;
    private Set<String> userAnswers;
    private Difficulty difficulty;
    private String userName;

    public static QuizzDTO toDTO(Quizz entity){
        if(entity == null)
            return null;

        return QuizzDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .goodAnswer(entity.getGoodAnswer())
                .questionList(entity.getQuestionList().stream().map(QuestionSmallDTO::toDTO).toList())
                .difficulty(entity.getDifficulty())
                .userName(entity.getUser().getUsername())
                .build();
    }
}

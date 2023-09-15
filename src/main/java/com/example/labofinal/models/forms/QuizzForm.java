package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.Difficulty;
import com.example.labofinal.models.entity.Quizz;
import lombok.Data;

import java.time.LocalDate;

@Data
public class QuizzForm {

    private Long difficultyId;
    private Long userId;
}

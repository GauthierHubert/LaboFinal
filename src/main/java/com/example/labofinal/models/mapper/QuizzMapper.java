package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.Quizz;
import com.example.labofinal.services.DifficultyService;
import com.example.labofinal.services.UserService;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QuizzMapper {

    private final DifficultyService difficultyService;
    private final UserService userService;

    public QuizzMapper(DifficultyService difficultyService, UserService userService) {
        this.difficultyService = difficultyService;
        this.userService = userService;
    }

    public Quizz toEntity(QuizzForm quizzForm){ // TODO QuizzForm
        Quizz quizz  = new Quizz();
        quizz.setDate(LocalDate.now());
        quizz.setDifficulty(difficultyService.getOne(quizzForm.getDifficultyId()));
        quizz.setUser(userService.getOne(quizzForm.getUserId()));
        return quizz;
    }




}

package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.Quizz;
import com.example.labofinal.services.DifficultyService;
import com.example.labofinal.services.QuestionService;
import com.example.labofinal.services.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QuizzMapper {

    private final DifficultyService difficultyService;
    private final UserService userService;
    private final QuestionService questionService;

    public QuizzMapper(DifficultyService difficultyService, UserService userService, QuestionService questionService) {
        this.difficultyService = difficultyService;
        this.userService = userService;
        this.questionService = questionService;
    }

    public Quizz toEntity(QuizzForm quizzForm){
        Quizz quizz  = new Quizz();
        quizz.setDate(LocalDate.now());
        quizz.setDifficulty(difficultyService.getOne(quizzForm.getDifficultyId()));
        quizz.setUser(userService.getOne(quizzForm.getUserId()));
        quizz.setQuestionList(questionService.getQuestionByDifficulty(quizz.getDifficulty()));
        return quizz;
    }




}

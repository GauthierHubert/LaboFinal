package com.example.labofinal.controllers;

import com.example.labofinal.models.dto.QuizzDTO;
import com.example.labofinal.models.forms.QuizzForm;
import com.example.labofinal.models.forms.QuizzMapper;
import com.example.labofinal.services.DifficultyService;
import com.example.labofinal.services.QuestionService;
import com.example.labofinal.services.QuizzService;
import com.example.labofinal.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizz")
public class QuizzController {

    private final QuizzService quizzService;
    private final UserService userService;
    private final DifficultyService difficultyService;
    private final QuestionService questionService;
    public QuizzController(QuizzService quizzService, UserService userService, DifficultyService difficultyService, QuestionService questionService) {
        this.quizzService = quizzService;
        this.userService = userService;
        this.difficultyService = difficultyService;
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody QuizzForm quizzForm){

        QuizzMapper quizzMapper = new QuizzMapper(difficultyService, userService, questionService);
        return ResponseEntity.status(HttpStatus.CREATED).body(quizzService.add(quizzMapper.toEntity(quizzForm)));
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<QuizzDTO> get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(QuizzDTO.toDTO(quizzService.getOne(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizzDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(quizzService.getAll().stream().map(QuizzDTO::toDTO).toList());
    }

}

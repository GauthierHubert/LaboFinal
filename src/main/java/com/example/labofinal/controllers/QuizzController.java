package com.example.labofinal.controllers;

import com.example.labofinal.models.dto.QuizzDTO;
import com.example.labofinal.models.entity.Quizz;
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
@CrossOrigin("*")
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
    public ResponseEntity<QuizzDTO> create(@RequestBody QuizzForm quizzForm){
        QuizzMapper quizzMapper = new QuizzMapper(difficultyService, userService, questionService);
        return ResponseEntity.status(HttpStatus.CREATED).body(QuizzDTO.toDTO(quizzService.create(quizzMapper.toEntity(quizzForm))));
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<QuizzDTO> get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(QuizzDTO.toDTO(quizzService.getOne(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizzDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(quizzService.getAll().stream().map(QuizzDTO::toDTO).toList());
    }

    @GetMapping("/all/{id:[0-9]+}")
    public ResponseEntity<List<QuizzDTO>> getAllByUser(@PathVariable Long id){
        return ResponseEntity.ok(quizzService.getQuizzById(this.userService.getOne(id)).stream().map(QuizzDTO::toDTO).toList());
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateQuizz(@RequestBody Quizz quizz){
        quizzService.update(1L, quizz);
        return ResponseEntity.ok().build();
    }
}

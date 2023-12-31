package com.example.labofinal.controllers;

import com.example.labofinal.models.dto.QuestionSmallDTO;
import com.example.labofinal.models.forms.AnswerForm;
import com.example.labofinal.models.forms.QuestionForm;
import com.example.labofinal.services.DifficultyService;
import com.example.labofinal.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final DifficultyService difficultyService;

    public QuestionController(QuestionService questionService, DifficultyService difficultyService) {
        this.questionService = questionService;
        this.difficultyService = difficultyService;
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody QuestionForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.add(form.toEntity()));
    }

    @GetMapping("/all")
    public ResponseEntity<Set<QuestionSmallDTO>> getAll(){
        return ResponseEntity.ok(questionService.getAll().stream().map(QuestionSmallDTO::toDTO).collect(Collectors.toSet()));
    }

    @GetMapping("/one/{id:[0-9]+}")
    public ResponseEntity<QuestionSmallDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(QuestionSmallDTO.toDTO(questionService.getOne(id)));
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody QuestionForm form){
        questionService.update(id, form.toEntity());
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/answers/{id:[0-9]+}")
    public ResponseEntity<Long> updateAnswers(@PathVariable Long id, @RequestBody List<AnswerForm> answerForms){
        questionService.answerUpdate(id, answerForms.stream().map(AnswerForm::toEntity).toList());
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        questionService.delete(id);
        return ResponseEntity.ok().build();
    }
}

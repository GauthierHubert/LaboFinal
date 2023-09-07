package com.example.labofinal.controllers;

import com.example.labofinal.models.dto.QuestionDTO;
import com.example.labofinal.models.entity.Question;
import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.forms.AnswerForm;
import com.example.labofinal.models.forms.QuestionForm;
import com.example.labofinal.services.QuestionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody QuestionForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.add(form.toEntity()));
    }

    @GetMapping("/all")
    public ResponseEntity<Set<QuestionDTO>> getAll(){
        return ResponseEntity.ok(questionService.getAll().stream().map(QuestionDTO::toDTO).collect(Collectors.toSet()));
    }

    @GetMapping
    public ResponseEntity<QuestionDTO> getOne(@RequestBody Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(QuestionDTO.toDTO(questionService.getOne(id)));
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

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id){
        questionService.delete(id);
        return ResponseEntity.ok().build();
    }

}

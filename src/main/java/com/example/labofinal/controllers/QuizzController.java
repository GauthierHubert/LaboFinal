package com.example.labofinal.controllers;

import com.example.labofinal.services.QuizzService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizz")
public class QuizzController {

    private final QuizzService quizzService;

    public QuizzController(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @PostMapping("/{id:[0-9]+}")
    public ResponseEntity<Long> add(@PathVariable Long id, @RequestBody QuizzForm quizzForm){
        quizzService
    }

}

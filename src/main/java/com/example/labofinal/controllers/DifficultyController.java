package com.example.labofinal.controllers;

import com.example.labofinal.models.dto.DifficultyDTO;
import com.example.labofinal.services.DifficultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/difficulty")
public class DifficultyController {

    private final DifficultyService difficultyService;

    public DifficultyController(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<DifficultyDTO>> getAll(){
        return ResponseEntity.ok(difficultyService.getAll().stream().map(DifficultyDTO::toDTO).collect(Collectors.toSet()));
    }
}

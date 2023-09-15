package com.example.labofinal.controllers;


import com.example.labofinal.models.dto.TypeDTO;
import com.example.labofinal.models.entity.Type;
import com.example.labofinal.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/type")
@CrossOrigin("*")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<TypeDTO>> getAll(){
        return ResponseEntity.ok().body(typeService.getAll().stream().map(TypeDTO::toDTO).collect(Collectors.toSet()));
    }
}

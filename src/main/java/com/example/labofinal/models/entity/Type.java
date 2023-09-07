package com.example.labofinal.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficulty_id", nullable = false)
    private Long id;

    @Column(name = "difficulty_name")
    private String name;

}

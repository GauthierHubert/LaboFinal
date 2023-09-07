package com.example.labofinal.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficulty_id", nullable = false)
    private Long id;

    @Column(name = "difficulty_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToMany
    @JoinTable(
            name = "prerequisites",
            joinColumns = @JoinColumn(name = "difficulty_id"),
            inverseJoinColumns = @JoinColumn(name = "prerequisites_difficulty_id")
    )
    private Set<Difficulty> prerequisites;
}

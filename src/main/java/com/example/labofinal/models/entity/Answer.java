package com.example.labofinal.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id", nullable = false)
    private Long id;

    @Column(name = "answer_title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    @Column(name = "answer_valid", nullable = false)
    private boolean valid;
}

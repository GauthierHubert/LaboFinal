package com.example.labofinal.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizz_id", nullable = false)
    private Long id;

    @Column(name = "quizz_date", nullable = false)
    private LocalDate date;

    @Column(name = "quizz_good_answer")
    private Integer goodAnswer = 0;

    @ManyToMany
    // TODO jointable
    @JoinTable(
            name= "quizz_question",
            joinColumns = @JoinColumn(name = "quizz_id"),
            inverseJoinColumns = @JoinColumn(name="question_id")
    )
    private Set<Question> questionList;

    @ManyToMany
    @JoinTable(
            name = "user_answer",
            joinColumns = @JoinColumn(name = "quizz_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<Answer> userAnswers;

    @ManyToOne
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "quizz_user_id")
    private User user;

}

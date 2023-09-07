package com.example.labofinal.repositories;

import com.example.labofinal.models.entity.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository  extends JpaRepository<Question, Long> {
}

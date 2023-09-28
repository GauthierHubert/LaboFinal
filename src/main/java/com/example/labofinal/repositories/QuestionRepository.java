package com.example.labofinal.repositories;

import com.example.labofinal.models.entity.Difficulty;
import com.example.labofinal.models.entity.Question;

import com.example.labofinal.models.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionRepository  extends JpaRepository<Question, Long> {
    List<Question> findAllByDifficulty(Difficulty difficulty);
}

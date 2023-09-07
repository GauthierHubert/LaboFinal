package com.example.labofinal.repositories;

import com.example.labofinal.models.entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzRepository extends JpaRepository<Quizz, Long> {
}

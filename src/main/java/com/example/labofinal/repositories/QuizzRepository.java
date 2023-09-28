package com.example.labofinal.repositories;

import com.example.labofinal.models.entity.Quizz;
import com.example.labofinal.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizzRepository extends JpaRepository<Quizz, Long> {

    List<Quizz> findAllByUser(User user);
}

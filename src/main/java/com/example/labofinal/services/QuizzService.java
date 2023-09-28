package com.example.labofinal.services;

import com.example.labofinal.models.entity.Quizz;
import com.example.labofinal.models.entity.User;

import java.util.List;

public interface QuizzService extends CrudService<Quizz, Long>{

    public Quizz create(Quizz entity);

    public List<Quizz> getQuizzById(User user);
}

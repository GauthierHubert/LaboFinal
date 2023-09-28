package com.example.labofinal.services.impl;

import com.example.labofinal.models.entity.Quizz;
import com.example.labofinal.models.entity.User;
import com.example.labofinal.repositories.QuizzRepository;
import com.example.labofinal.services.QuizzService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzServiceImpl implements QuizzService {
    public QuizzRepository quizzRepository;

    public QuizzServiceImpl(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    @Override
    public Long add(Quizz entity) {
        quizzRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Quizz create(Quizz entity) {
        quizzRepository.save(entity);
        return entity;
    }

    @Override
    public List<Quizz> getQuizzById(User user) {

        return quizzRepository.findAllByUser(user);
    }

    @Override
    public List<Quizz> getAll() {
        return quizzRepository.findAll();
    }

    @Override
    public Quizz getOne(Long id) {
        return quizzRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id, Quizz entity) {
        quizzRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        quizzRepository.delete(getOne(id));
    }
}

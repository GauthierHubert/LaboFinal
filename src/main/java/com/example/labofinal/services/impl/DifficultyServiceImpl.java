package com.example.labofinal.services.impl;

import com.example.labofinal.models.entity.Difficulty;
import com.example.labofinal.repositories.DifficultyRepository;
import com.example.labofinal.services.DifficultyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DifficultyServiceImpl implements DifficultyService {

    private final DifficultyRepository difficultyRepository;

    public DifficultyServiceImpl(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    public Long add(Difficulty entity) {
        return difficultyRepository.save(entity).getId();
    }

    @Override
    public List<Difficulty> getAll() {
        return difficultyRepository.findAll();
    }

    @Override
    public Difficulty getOne(Long id) {
        return difficultyRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id, Difficulty entity) {
        entity.setId(id);
        difficultyRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        difficultyRepository.delete(getOne(id));
    }
}

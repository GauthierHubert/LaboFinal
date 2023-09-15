package com.example.labofinal.services.impl;

import com.example.labofinal.models.entity.Type;
import com.example.labofinal.repositories.TypeRepository;
import com.example.labofinal.services.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> getAll() {
        return this.typeRepository.findAll();
    }
}

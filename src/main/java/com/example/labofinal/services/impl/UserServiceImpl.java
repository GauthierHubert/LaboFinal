package com.example.labofinal.services.impl;

import com.example.labofinal.models.entity.User;
import com.example.labofinal.repositories.UserRepository;
import com.example.labofinal.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    public UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long add(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
       userRepository.save(entity);
       return entity.getId();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id, User entity) {
        entity.setId(id);
        userRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getOne(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.getUserByUsername(username).orElseThrow();
    }

    @Override
    public User login(User entity) {
        User existingUser = userRepository.getUserByUsername(entity.getUsername()).orElseThrow();
        if(!passwordEncoder.matches(entity.getPassword(), existingUser.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        return existingUser;
    }
}

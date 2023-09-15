package com.example.labofinal.utils;


import com.example.labofinal.models.entity.Difficulty;
import com.example.labofinal.models.entity.Type;
import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.entity.enums.Role;
import com.example.labofinal.repositories.DifficultyRepository;
import com.example.labofinal.repositories.TypeRepository;
import com.example.labofinal.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TypeRepository typeRepository;
    private final PasswordEncoder passwordEncoder;
    private final DifficultyRepository difficultyRepository;

    public DataInitializer(UserRepository userRepository, TypeRepository typeRepository, PasswordEncoder passwordEncoder, DifficultyRepository difficultyRepository) {
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.passwordEncoder = passwordEncoder;
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        String pwd = passwordEncoder.encode("Test1234=");

        User user = new User();
        user.setUsername("LeTest1");
        user.setMail("test@gmail.com");
        user.setPassword(pwd);
        user.setRank(0);
        user.setActive(true);
        user.setRoles(Set.of(Role.ROLE_USER));
        userRepository.save(user);

        User user1 = new User();
        user1.setUsername("LeTestAdmin");
        user1.setMail("test2@gmail.com");
        user1.setPassword(pwd);
        user1.setRank(0);
        user1.setActive(true);
        user1.setRoles(Set.of(Role.ROLE_ADMIN));
        userRepository.save(user1);

        Type type = new Type();
        type.setName("JAVA");
        typeRepository.save(type);

        Type type1 = new Type();
        type1.setName("SPRING");
        typeRepository.save(type1);

        Difficulty difficulty = new Difficulty();
        difficulty.setName("normal");
        difficulty.setType(type);
        difficultyRepository.save(difficulty);

        Difficulty difficulty2 = new Difficulty();
        difficulty2.setName("avancé");
        difficulty2.setType(type);
        difficultyRepository.save(difficulty2);

        Difficulty difficulty3 = new Difficulty();
        difficulty3.setName("expert");
        difficulty3.setType(type);
        difficultyRepository.save(difficulty3);

        Difficulty difficulty4 = new Difficulty();
        difficulty4.setName("débutant");
        difficulty4.setType(type1);
        difficultyRepository.save(difficulty4);

        Difficulty difficulty5 = new Difficulty();
        difficulty5.setName("impossible");
        difficulty5.setType(type1);
        difficultyRepository.save(difficulty5);
    }
}

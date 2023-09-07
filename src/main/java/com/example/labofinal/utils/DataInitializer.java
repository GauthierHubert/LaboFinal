package com.example.labofinal.utils;


import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.entity.enums.Role;
import com.example.labofinal.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    }
}

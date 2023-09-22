package com.example.labofinal.controllers.security;

import com.example.labofinal.models.dto.security.UserTokenDTO;
import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.forms.security.UserLoginForm;
import com.example.labofinal.services.EmailService;
import com.example.labofinal.utils.JwtUtil;
import com.example.labofinal.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;
    private final EmailService emailService;

    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, EmailService emailService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.emailService = emailService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(
            @RequestBody @Valid UserLoginForm login
    ){
     // emailService.sendVerificationCode("ghubhouille@gmail.com", "1234"); TODO
        User user = userService.login(login.toEntity());
        UserTokenDTO dto = UserTokenDTO.toDTO(user);
        String token = jwtUtil.generateToken(user);
        dto.setToken(token);
        System.out.println(jwtUtil.getRoles(token));
        return ResponseEntity.ok(dto);
    }
}

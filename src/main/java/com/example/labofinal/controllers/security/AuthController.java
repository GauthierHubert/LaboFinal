package com.example.labofinal.controllers.security;

import com.example.labofinal.models.dto.security.UserTokenDTO;
import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.forms.security.UserLoginForm;
import com.example.labofinal.utils.JwtUtil;
import com.example.labofinal.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(
            @RequestBody @Valid UserLoginForm login
    ){
        User user = userService.login(login.toEntity());
        UserTokenDTO dto = UserTokenDTO.toDTO(user);
        String token = jwtUtil.generateToken(user);
        dto.setToken(token);
        System.out.println(jwtUtil.getRoles(token));
        return ResponseEntity.ok(dto);
    }
}

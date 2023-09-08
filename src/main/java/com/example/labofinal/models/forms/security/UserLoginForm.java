package com.example.labofinal.models.forms.security;

import com.example.labofinal.models.entity.User;
import lombok.Data;

@Data
public class UserLoginForm {

    private String username;

    private String password;

    public User toEntity(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}

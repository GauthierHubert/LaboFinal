package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {

    @NotBlank
    @Size(min = 6, max = 20)
    private String username;

    @NotBlank
    @Email
    private String mail;

    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[!=@#|$%^&*()_+{}\\\\[\\\\]:;<>,.?~\\\\-]).*(?=.*[A-Z]).*(?=.*[0-9]).*$")
    private String password;

    @NotBlank
    private Role role;


    public User toEntity(){
        System.out.println("test");
        User user = new User();
        user.setUsername(username);
        user.setMail(mail);
        user.setPassword(password);
        user.setRank(0);
        user.getRoles().add(role);
        return user;
    }
}

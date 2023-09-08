package com.example.labofinal.models.dto.security;

import com.example.labofinal.models.dto.UserDTO;
import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.entity.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserTokenDTO {

    private String token;

    private UserDTO user;

    public static UserTokenDTO toDTO(User user){
        UserTokenDTO dto = new UserTokenDTO();
        dto.setUser(UserDTO.toDto(user));
        return dto;
    }
}

package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.User;
import com.example.labofinal.models.entity.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String mail;
    private Integer rank;
    private Set<Role> roles;

    public static UserDTO toDto (User entity){
        if(entity == null)
            return  null;

        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .mail(entity.getMail())
                .rank(entity.getRank())
                .roles(entity.getRoles())
                .build();
    }
}

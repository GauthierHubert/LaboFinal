package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeDTO {

    private Long id;
    private String name;

    public static TypeDTO toDTO(Type entity){
        return TypeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}

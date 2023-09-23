package com.example.labofinal.models.dto;

import com.example.labofinal.models.entity.Difficulty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DifficultyDTO {
    private Long id;
    private String name;
    private TypeDTO type;

    public static DifficultyDTO toDTO(Difficulty entity){
        return DifficultyDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(TypeDTO.toDTO(entity.getType()))
                .build();
    }
}

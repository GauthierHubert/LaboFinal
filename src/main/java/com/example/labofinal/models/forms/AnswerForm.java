package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.Answer;
import com.example.labofinal.models.entity.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerForm {

    private String title;
    private Boolean valid = false;

    public Answer toEntity(){
        Answer answer = new Answer();
        answer.setTitle(title);
        answer.setValid(valid);
        return answer;
    }
}

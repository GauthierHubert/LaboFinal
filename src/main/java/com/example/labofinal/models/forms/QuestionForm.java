package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class QuestionForm {

    private String title;

    private  String explication;

    private List<AnswerForm> answers;

    public Question toEntity(){
        Question question = new Question();
        question.setTitle(title);
        question.setExplication(explication);
        question.setAnswers(answers.stream().map(AnswerForm::toEntity).toList());
        question.setIsAccepted(false);
        return question;
    }
}

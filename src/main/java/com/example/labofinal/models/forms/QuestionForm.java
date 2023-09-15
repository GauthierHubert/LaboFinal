package com.example.labofinal.models.forms;

import com.example.labofinal.models.entity.Question;
import com.example.labofinal.models.entity.Type;
import com.example.labofinal.models.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class QuestionForm {

    private String title;

    private  String explication;

    private Type type;

    private Set<AnswerForm> answers;

    private User creator;

    public Question toEntity(){
        Question question = new Question();
        question.setTitle(title);
        question.setExplication(explication);
        question.setAnswers(answers.stream().map(AnswerForm::toEntity).collect(Collectors.toSet()));
        question.setIsAccepted(false);
        question.setType(type);
        question.setCreator(creator);
        return question;
    }
}

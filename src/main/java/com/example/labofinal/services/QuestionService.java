package com.example.labofinal.services;

import com.example.labofinal.models.entity.Answer;
import com.example.labofinal.models.entity.Difficulty;
import com.example.labofinal.models.entity.Question;
import com.example.labofinal.models.entity.Type;


import java.util.List;
import java.util.Set;

public interface QuestionService extends CrudService<Question, Long>{

    Long answerUpdate(Long id, List<Answer> answers);

    public Set<Question> getQuestionByDifficulty(Difficulty difficulty);

}

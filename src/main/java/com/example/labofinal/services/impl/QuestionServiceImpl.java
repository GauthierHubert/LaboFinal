package com.example.labofinal.services.impl;

import com.example.labofinal.models.entity.Answer;
import com.example.labofinal.models.entity.Difficulty;
import com.example.labofinal.models.entity.Question;
import com.example.labofinal.models.entity.Type;
import com.example.labofinal.repositories.AnswerRepository;
import com.example.labofinal.repositories.QuestionRepository;
import com.example.labofinal.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository, AnswerRepository answerRepository1) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository1;
    }

    @Override
    public Long add(Question entity) {

        Question finalEntity = questionRepository.save(entity);

        List<Answer> answers = entity.getAnswers();
        answers.forEach(answer -> answer.setQuestion(finalEntity) );

        answerRepository.saveAll( answers );

        return finalEntity.getId();

    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id, Question entity) {
        entity.setId(id);
        questionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        questionRepository.delete(getOne(id));
    }

    @Override //TODO C'EST BUGGER FAUT LE FINIR
    public Long answerUpdate(Long id, List<Answer> answers) {

        Question question = getOne(id);

        answerRepository.deleteAll(question.getAnswers());

        answers.forEach(answer -> answer.setQuestion(question));
        answers = answerRepository.saveAll(answers);

        question.setAnswers(answers);

        return question.getId();
    }

    @Override
    public Set<Question> getQuestionByDifficulty(Difficulty difficulty) {
        return questionRepository.findAllByDifficulty(difficulty);
    }
}

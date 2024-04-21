package me.ankanroychowdhury.quorabackend.services;

import me.ankanroychowdhury.quorabackend.entities.Question;

import java.util.List;

public interface QuestionService {
    public Question postQuestion(Question question) throws Exception;
    public List<Question> searchQuestions(String text, String tag) throws Exception;
}

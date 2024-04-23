package me.ankanroychowdhury.quorabackend.services;

import me.ankanroychowdhury.quorabackend.entities.Answer;

public interface AnswerService {
    public Answer editAnswer(Long answerId, String text) throws Exception;
}

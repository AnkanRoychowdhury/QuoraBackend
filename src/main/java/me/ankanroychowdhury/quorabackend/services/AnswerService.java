package me.ankanroychowdhury.quorabackend.services;

import me.ankanroychowdhury.quorabackend.entities.Answer;
import me.ankanroychowdhury.quorabackend.entities.Comment;

public interface AnswerService {
    public Answer editAnswer(Long answerId, String text) throws Exception;
    public Comment commentOnAnswer(Long answerId, Comment comment) throws Exception;
}

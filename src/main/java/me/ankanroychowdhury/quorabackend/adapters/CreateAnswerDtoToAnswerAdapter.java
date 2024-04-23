package me.ankanroychowdhury.quorabackend.adapters;

import me.ankanroychowdhury.quorabackend.dtos.CreateAnswerDTO;
import me.ankanroychowdhury.quorabackend.dtos.CreateQuestionDTO;
import me.ankanroychowdhury.quorabackend.entities.Answer;

public interface CreateAnswerDtoToAnswerAdapter {
    public Answer convertDto(CreateAnswerDTO createAnswerDTO) throws Exception;
}

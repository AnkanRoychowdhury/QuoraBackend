package me.ankanroychowdhury.quorabackend.adapters;

import me.ankanroychowdhury.quorabackend.dtos.CreateQuestionDTO;
import me.ankanroychowdhury.quorabackend.entities.Question;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

public interface CreateQuestionDtoToQuestionAdapter {
    public Question convertDTO(CreateQuestionDTO createQuestionDTO) throws Exception;
}

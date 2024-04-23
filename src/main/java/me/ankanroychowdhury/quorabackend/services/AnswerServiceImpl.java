package me.ankanroychowdhury.quorabackend.services;

import jakarta.persistence.EntityNotFoundException;
import me.ankanroychowdhury.quorabackend.entities.Answer;
import me.ankanroychowdhury.quorabackend.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer editAnswer(Long answerId, String text) throws Exception{
        try {
            Answer answer = this.answerRepository.findById(answerId).orElseThrow(EntityNotFoundException::new);
            answer.setText(text);
            return this.answerRepository.save(answer);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to update the answer currently try later");
        }
    }
}

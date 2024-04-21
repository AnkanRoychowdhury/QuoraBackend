package me.ankanroychowdhury.quorabackend.services;

import me.ankanroychowdhury.quorabackend.entities.Question;
import me.ankanroychowdhury.quorabackend.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question postQuestion(Question question) throws Exception{
        try {
            return this.questionRepository.save(question);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to post the question");
        }
    }

    @Override
    public List<Question> searchQuestions(String text, String tag) throws Exception {
        try {
            return this.questionRepository.findAllByTitleContainsAndDescriptionContains(text,text);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to search the questions");
        }
    }

}

package me.ankanroychowdhury.quorabackend.services;

import jakarta.persistence.EntityNotFoundException;
import me.ankanroychowdhury.quorabackend.entities.Answer;
import me.ankanroychowdhury.quorabackend.entities.Question;
import me.ankanroychowdhury.quorabackend.repositories.AnswerRepository;
import me.ankanroychowdhury.quorabackend.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
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
            return this.questionRepository.findAllByTitleContainsOrDescriptionContains(text,text);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to search the questions");
        }
    }

    @Override
    public Answer postAnswer(Long questionId, Answer answer) throws Exception {
        try {
           Question question = this.questionRepository.findById(questionId).orElse(null);
           Answer savedAnswer = null;
           if(question != null) {
               answer.setQuestion(question);
               savedAnswer = this.answerRepository.save(answer);
               question.getAnswers().add(savedAnswer);
               this.questionRepository.save(question);
           }
           return savedAnswer;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to post the answer");
        }
    }

}

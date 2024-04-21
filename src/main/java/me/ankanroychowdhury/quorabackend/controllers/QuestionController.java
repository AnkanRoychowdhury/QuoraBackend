package me.ankanroychowdhury.quorabackend.controllers;

import me.ankanroychowdhury.quorabackend.adapters.CreateQuestionDtoToQuestionAdapter;
import me.ankanroychowdhury.quorabackend.dtos.CreateQuestionDTO;
import me.ankanroychowdhury.quorabackend.dtos.QuestionDto;
import me.ankanroychowdhury.quorabackend.entities.Question;
import me.ankanroychowdhury.quorabackend.entities.Topic;
import me.ankanroychowdhury.quorabackend.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private QuestionService questionService;
    private CreateQuestionDtoToQuestionAdapter createQuestionDtoToQuestionAdapter;

    public QuestionController(QuestionService questionService, CreateQuestionDtoToQuestionAdapter createQuestionDtoToQuestionAdapter) {
        this.questionService = questionService;
        this.createQuestionDtoToQuestionAdapter = createQuestionDtoToQuestionAdapter;
    }

    @PostMapping
    public ResponseEntity<?> postQuestion(@RequestBody CreateQuestionDTO questionDTO) {
        try {
            Question convertedQuestion = this.createQuestionDtoToQuestionAdapter.convertDTO(questionDTO);
            Question savedQuestion = this.questionService.postQuestion(convertedQuestion);
            QuestionDto response = createQuestionDtoResponse(savedQuestion);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchQuestion(@RequestParam String text, @RequestParam String tag) throws Exception{
        try {
            List<Question> matchedQuestions = this.questionService.searchQuestions(text, tag);
            List<QuestionDto> questionDtos = new ArrayList<>();
            for(Question matchedQuestion : matchedQuestions){
                createQuestionDtoResponse(matchedQuestion);
                QuestionDto questionDto = createQuestionDtoResponse(matchedQuestion);
                questionDtos.add(questionDto);
            }
            return new ResponseEntity<>(questionDtos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private QuestionDto createQuestionDtoResponse(Question matchedQuestion) {
        List<Topic> topics = matchedQuestion.getTopics();
        List<String> topicNames = new ArrayList<>();
        for (Topic topic : topics) {
            topicNames.add(topic.getName());
        }
        return QuestionDto.builder()
                .id(matchedQuestion.getId())
                .title(matchedQuestion.getTitle())
                .author(matchedQuestion.getUser().getId())
                .description(matchedQuestion.getDescription())
                .tags(topicNames)
                .createdAt(matchedQuestion.getCreatedAt())
                .updatedAt(matchedQuestion.getUpdatedAt())
                .build();
    }
}

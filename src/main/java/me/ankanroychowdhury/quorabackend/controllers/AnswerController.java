package me.ankanroychowdhury.quorabackend.controllers;

import me.ankanroychowdhury.quorabackend.dtos.AnswerDTO;
import me.ankanroychowdhury.quorabackend.dtos.QuestionDto;
import me.ankanroychowdhury.quorabackend.entities.Answer;
import me.ankanroychowdhury.quorabackend.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/answers")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<?> editAnswer(@PathVariable Long answerId, @RequestBody String text) throws Exception{
        try {
            Answer answer = this.answerService.editAnswer(answerId, text);
            AnswerDTO response = AnswerDTO.builder()
                    .id(answer.getId())
                    .answeredBy(answer.getUser().getUsername())
                    .question(QuestionDto.builder().title(answer.getQuestion().getTitle()).build())
                    .content(answer.getText())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

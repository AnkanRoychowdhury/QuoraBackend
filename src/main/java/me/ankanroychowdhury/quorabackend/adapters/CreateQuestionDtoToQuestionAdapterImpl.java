package me.ankanroychowdhury.quorabackend.adapters;

import jakarta.persistence.EntityNotFoundException;
import me.ankanroychowdhury.quorabackend.dtos.CreateQuestionDTO;
import me.ankanroychowdhury.quorabackend.entities.Question;
import me.ankanroychowdhury.quorabackend.entities.Topic;
import me.ankanroychowdhury.quorabackend.entities.User;
import me.ankanroychowdhury.quorabackend.repositories.TopicRepository;
import me.ankanroychowdhury.quorabackend.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateQuestionDtoToQuestionAdapterImpl implements CreateQuestionDtoToQuestionAdapter{
    private UserRepository userRepository;
    private TopicRepository topicRepository;

    public CreateQuestionDtoToQuestionAdapterImpl(UserRepository userRepository, TopicRepository topicRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }
    @Override
    public Question convertDTO(CreateQuestionDTO createQuestionDTO) throws Exception{
        try {
            Optional<User> user = this.userRepository.findById(createQuestionDTO.getUserId());
            if(user.isEmpty()){
                throw new EntityNotFoundException("User not found with id " + createQuestionDTO.getUserId());
            }
            List<Long> topicIds = createQuestionDTO.getTopics();
            List<Topic> topics = new ArrayList<>();
            if(!topicIds.isEmpty()){
                for(Long topicId : topicIds){
                    Topic topic = this.topicRepository.findById(topicId).orElseThrow(EntityNotFoundException::new);
                    topics.add(topic);
                }
            }
            Question question = Question.builder()
                                .title(createQuestionDTO.getTitle())
                                .description(createQuestionDTO.getDescription())
                                .user(user.get())
                                .topics(topics)
                                .build();
            return question;
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}

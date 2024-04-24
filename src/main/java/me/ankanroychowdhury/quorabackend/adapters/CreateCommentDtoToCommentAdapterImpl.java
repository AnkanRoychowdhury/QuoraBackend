package me.ankanroychowdhury.quorabackend.adapters;

import jakarta.persistence.EntityNotFoundException;
import me.ankanroychowdhury.quorabackend.dtos.CreateCommentDTO;
import me.ankanroychowdhury.quorabackend.entities.Comment;
import me.ankanroychowdhury.quorabackend.entities.User;
import me.ankanroychowdhury.quorabackend.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateCommentDtoToCommentAdapterImpl implements CreateCommentDtoToCommentAdapter{
    private UserRepository userRepository;

    public CreateCommentDtoToCommentAdapterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Comment convertDTO(CreateCommentDTO createCommentDTO) throws Exception {
        try {
            User user = this.userRepository.findById(createCommentDTO.getUserId()).orElseThrow(EntityNotFoundException::new);
            return Comment.builder()
                    .content(createCommentDTO.getContent())
                    .user(user)
                    .build();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}

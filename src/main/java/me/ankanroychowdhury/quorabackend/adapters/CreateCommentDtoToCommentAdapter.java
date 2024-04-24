package me.ankanroychowdhury.quorabackend.adapters;

import me.ankanroychowdhury.quorabackend.dtos.CreateCommentDTO;
import me.ankanroychowdhury.quorabackend.entities.Comment;

public interface CreateCommentDtoToCommentAdapter {
    public Comment convertDTO(CreateCommentDTO createCommentDTO) throws Exception;
}

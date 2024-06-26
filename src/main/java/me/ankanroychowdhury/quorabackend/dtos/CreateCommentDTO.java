package me.ankanroychowdhury.quorabackend.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCommentDTO {
    private Long userId;
    private String content;
}

package me.ankanroychowdhury.quorabackend.dtos;

import lombok.*;
import me.ankanroychowdhury.quorabackend.entities.Topic;

import java.util.Date;
import java.util.List;

/**
 * DTO for {@link me.ankanroychowdhury.quorabackend.entities.Question}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private String title;
    private String description;
    private Long author;
    private List<String> tags;
    private Date createdAt;
    private Date updatedAt;
}
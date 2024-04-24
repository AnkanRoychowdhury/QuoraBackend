package me.ankanroychowdhury.quorabackend.repositories;

import me.ankanroychowdhury.quorabackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}

package me.ankanroychowdhury.quorabackend.repositories;

import me.ankanroychowdhury.quorabackend.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

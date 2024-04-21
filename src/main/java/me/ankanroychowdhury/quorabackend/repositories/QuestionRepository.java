package me.ankanroychowdhury.quorabackend.repositories;

import me.ankanroychowdhury.quorabackend.entities.Question;

import me.ankanroychowdhury.quorabackend.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTitleContainsAndDescriptionContains(String title, String description);
}

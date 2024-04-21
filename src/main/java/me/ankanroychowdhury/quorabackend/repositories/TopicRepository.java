package me.ankanroychowdhury.quorabackend.repositories;

import me.ankanroychowdhury.quorabackend.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}

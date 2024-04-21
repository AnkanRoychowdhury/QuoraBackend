package me.ankanroychowdhury.quorabackend;

import me.ankanroychowdhury.quorabackend.repositories.QuestionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuoraBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoraBackendApplication.class, args);
    }

}

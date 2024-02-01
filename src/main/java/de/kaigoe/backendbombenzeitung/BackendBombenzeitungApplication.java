package de.kaigoe.backendbombenzeitung;

import de.kaigoe.backendbombenzeitung.Entity.Person;
import de.kaigoe.backendbombenzeitung.Repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;

@SpringBootApplication
public class BackendBombenzeitungApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendBombenzeitungApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PersonRepository repository) {
        return args -> {
            Person person = new Person("kai", "amongus");

            repository.save(person);
            Person saved = repository.findById(person.getId()).orElseThrow(IOException::new);
        };
    }
}

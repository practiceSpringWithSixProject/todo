package com.example.todo;

import com.example.todo.entities.Author;
import com.example.todo.entities.TodoGroup;
import com.example.todo.repositories.AuthorRepository;
import com.example.todo.repositories.TodoGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AuthorRepository repository, TodoGroupRepository tr) {
        return args -> {
            log.info("Preloading " + repository.save(new Author("Bilbo Baggins")));
            log.info("Preloading " + repository.save(new Author("Frodo Baggins")));
            log.info("Preloading " + tr.save(new TodoGroup("aaaa")));
        };
    }
}

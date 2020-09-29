package com.todolist.todoListGeo.model;

import com.todolist.todoListGeo.service.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDB {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);


    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new TodoItem("Study for exams", "Study for Software Development II course.",false)));
            logger.info("Preloading " + repository.save(new TodoItem("Study for personal project", "I have to study about Spring Framework",false)));
        };
    }
}

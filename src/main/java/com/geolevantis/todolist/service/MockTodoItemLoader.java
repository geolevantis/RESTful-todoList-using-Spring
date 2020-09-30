package com.geolevantis.todolist.service;

import com.geolevantis.todolist.model.TodoItem;
import com.geolevantis.todolist.repository.TodoItemRepository;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Profile("mock")
public class MockTodoItemLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunner.class);

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public MockTodoItemLoader(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
        createMockData();
    }

    private void createMockData() {
        ImmutableList<TodoItem> todoItems = ImmutableList.of(
                new TodoItem("Study for exams", "Study for Software Development II course.", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false),
                new TodoItem("Study for personal project", "I have to study about Spring Framework", false)
        );
        saveTodoItems(todoItems);
        saveTodoItem(new TodoItem("omg", "wow", true));
    }

    private void saveTodoItems(Collection<TodoItem> todoItem) {
        LOGGER.info("Preloading all: {}", todoItemRepository.saveAll(todoItem));
    }

    private void saveTodoItem(TodoItem todoItem) {
        LOGGER.info("Preloading {}", todoItemRepository.save(todoItem));
    }
}

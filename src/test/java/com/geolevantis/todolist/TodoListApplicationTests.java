package com.geolevantis.todolist;

import com.geolevantis.todolist.controller.TodoItemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    private TodoItemController todoItemController;

    @Test
    void testContextLoads() {
        assertThat(todoItemController).isNotNull();
    }
}

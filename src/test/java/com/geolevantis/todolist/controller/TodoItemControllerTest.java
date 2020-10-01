package com.geolevantis.todolist.controller;

import com.geolevantis.todolist.TodoListApplication;
import com.geolevantis.todolist.model.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = TodoListApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testGetAllTodoItems() {
        // given
        String url = getRootUrl() + "/todo";

        // when
        TodoItem[] todoList = restTemplate.getForObject(url, TodoItem[].class);

        // then
        assertThat(todoList).isNotNull();
        assertThat(todoList).hasSize(10);
        assertThat(todoList).allSatisfy(todoItem -> {
            assertThat(todoItem.getId()).isNotNull();
            assertThat(todoItem.getTitle()).isNotEmpty();
            assertThat(todoItem.getContent()).isNotEmpty();
        });
    }

    @Test
    public void testCreateTodoItem() {
        // given
        String url = getRootUrl() + "/todo";

        TodoItem requestTodo = new TodoItem();
        requestTodo.setTitle("Study for Spring");
        requestTodo.setContent("I have to study Spring Framework in order to become a better developer!");
        requestTodo.setCompleted(false);

        // when
        ResponseEntity<TodoItem> postResponse = restTemplate.postForEntity(url, requestTodo, TodoItem.class);

        // then
        assertThat(postResponse).isNotNull();

        TodoItem responseTodo = postResponse.getBody();
        assertThat(responseTodo).isNotNull();
        assertThat(responseTodo.getId()).isNotNull();
        assertThat(responseTodo.getTitle()).isEqualTo(requestTodo.getTitle());
        assertThat(responseTodo.getContent()).isEqualTo(requestTodo.getContent());
        assertThat(responseTodo.isCompleted()).isFalse();
    }

    // todo More tests to be added! (update, delete methods etc)


}

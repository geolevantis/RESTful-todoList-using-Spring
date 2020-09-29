package com.todolist.todoListGeo;

import com.todolist.todoListGeo.model.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.junit.Assert;


@SpringBootTest(classes = TodoListGeoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TodoTestJpa {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/toDo",
                HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
    }


    @Test
    public void testCreateTask() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Study for Spring");
        todoItem.setContent("I have to study Spring Framework in order to become a better developer!");
        todoItem.setCompleted(false);

        ResponseEntity<TodoItem> postResponse = restTemplate.postForEntity(getRootUrl() + "/toDo", todoItem, TodoItem.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    //More tests to be added!


}

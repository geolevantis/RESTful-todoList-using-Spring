package com.todolist.todoListGeo;

import com.todolist.todoListGeo.controller.TodoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodoListGeoApplicationTests {
	@Autowired
	private TodoController todoController;

	@Test
	void contextLoads() throws Exception{
		assertThat(todoController).isNotNull();
	}

}

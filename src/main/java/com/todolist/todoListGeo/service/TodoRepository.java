package com.todolist.todoListGeo.service;

import com.todolist.todoListGeo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Integer> {
}

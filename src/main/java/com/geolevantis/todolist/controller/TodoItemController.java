package com.geolevantis.todolist.controller;

import com.geolevantis.todolist.model.TodoItem;
import com.geolevantis.todolist.repository.TodoItemRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoItemController {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    private List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    private TodoItem findById(@PathVariable int id) throws ResourceNotFoundException {
        return todoItemRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with " + id + " not found!"));
    }

    @PostMapping
    private TodoItem save(@RequestBody TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @PutMapping
    private TodoItem update(@RequestBody TodoItem todoItem) {
        // todo update something that already exists, you need to look it up first!
        return todoItemRepository.save(todoItem);
    }

    // todo we generally avoid commented out code into the repository
//    @PutMapping(value = "/{id}")
//    private TodoItem updateById(@PathVariable int id, @RequestBody TodoItem todoItem)
//            throws ResourceNotFoundException {
//        todoRepository
//                .findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Task not found on :: " + id));
//        return todoRepository.save(todoItem);
//
//    }

    @DeleteMapping(value = "/{id}")
    private void deleteById(@PathVariable int id) {
        todoItemRepository.deleteById(id);
    }

    @DeleteMapping
    private void deleteAll() {
        todoItemRepository.deleteAll();
    }
}

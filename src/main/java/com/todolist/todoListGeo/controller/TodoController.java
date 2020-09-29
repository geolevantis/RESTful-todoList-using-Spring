package com.todolist.todoListGeo.controller;

import com.todolist.todoListGeo.model.TodoItem;
import com.todolist.todoListGeo.service.TodoRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/toDo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;


    @GetMapping
    private List<TodoItem> getAll() {
        return todoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    private Optional<TodoItem> getById(@PathVariable int id)
            throws ResourceNotFoundException {
        todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found on :: " + id));
        return todoRepository.findById(id);

    }


    @PostMapping
    private TodoItem save(@RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @PutMapping
    private TodoItem update(@RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

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
    private void delete(@PathVariable int id) {
        todoRepository.deleteById(id);
    }

    @DeleteMapping
    private void deleteAll() {
        todoRepository.deleteAll();
    }


}

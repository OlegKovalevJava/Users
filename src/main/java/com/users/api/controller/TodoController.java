package com.users.api.controller;

import com.users.api.entity.TodoEntity;
import com.users.api.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("invalid request");
        }
    }

    @PutMapping
    public ResponseEntity<?> completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("invalid request");
        }
    }

}
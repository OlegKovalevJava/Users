package com.users.api.service;

import com.users.api.entity.TodoEntity;
import com.users.api.entity.UserEntity;
import com.users.api.model.TodoModel;
import com.users.api.repository.TodoRepo;
import com.users.api.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    private final UserRepo userRepo;

    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public TodoModel createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return TodoModel.todoModel(todoRepo.save(todo));
    }

    public TodoModel complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return TodoModel.todoModel(todoRepo.save(todo));
    }

}
package com.users.api.model;

import com.users.api.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserModel {

    private Long id;
    private String username;
    private List<TodoModel> todos;

    public static UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(TodoModel::todoModel).collect(Collectors.toList()));
        return model;
    }

}
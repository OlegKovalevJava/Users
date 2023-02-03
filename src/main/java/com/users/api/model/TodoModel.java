package com.users.api.model;

import com.users.api.entity.TodoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoModel {
    private Long id;
    private String title;
    private Boolean completed;

    public static TodoModel todoModel(TodoEntity entity) {
        TodoModel model = new TodoModel();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }
}

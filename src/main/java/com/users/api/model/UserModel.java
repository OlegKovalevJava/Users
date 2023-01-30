package com.users.api.model;

import com.users.api.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserModel {

    private Long id;
    private String username;

    public static UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return model;
    }

}
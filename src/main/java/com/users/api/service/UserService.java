package com.users.api.service;

import com.users.api.entity.UserEntity;
import com.users.api.exception.UserAlreadyExistException;
import com.users.api.model.UserModel;
import com.users.api.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("user with this name already exists");
        }
        return userRepo.save(user);
    }

    public UserModel getUser(Long id) {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("user with this id was not found"));
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
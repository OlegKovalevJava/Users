package com.users.api.service;

import com.users.api.entity.UserEntity;
import com.users.api.exception.UserAlreadyExistException;
import com.users.api.exception.UserNotFoundException;
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
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public UserModel getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (userRepo.findById(id) == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.toModel(user);
    }

}
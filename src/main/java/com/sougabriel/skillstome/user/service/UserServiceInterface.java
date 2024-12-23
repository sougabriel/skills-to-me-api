package com.sougabriel.skillstome.service;

import com.sougabriel.skillstome.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {

    UserModel save(UserModel userModel);

    List<UserModel> findAll();

    Optional<UserModel> findById(UUID id);

    UserModel update(UserModel userModel);

    void deleteById(UUID id);
}

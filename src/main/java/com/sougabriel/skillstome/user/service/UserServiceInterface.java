package com.sougabriel.skillstome.user.service;

import com.sougabriel.skillstome.user.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {

    UserModel save(UserModel userModel);

    List<UserModel> findAll();

    Optional<UserModel> findById(UUID id);

    Optional<UserModel> findByEmail(String email);

    UserModel update(UserModel userModel);

    void deleteById(UUID id);
}

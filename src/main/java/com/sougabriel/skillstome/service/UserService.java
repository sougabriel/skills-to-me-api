package com.sougabriel.skillstome.service;

import com.sougabriel.skillstome.model.UserModel;
import com.sougabriel.skillstome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel save(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

    @Override
    public List<UserModel> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(UUID id) {
        return this.userRepository.findById(id);
    }

    @Override
    public UserModel update(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

    @Override
    public void deleteById(UUID id) {
        this.userRepository.deleteById(id);
    }
}

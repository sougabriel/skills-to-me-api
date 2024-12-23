package com.sougabriel.skillstome.user.service;

import com.sougabriel.skillstome.user.model.UserModel;
import com.sougabriel.skillstome.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserModel save(UserModel userModel) {
        String password = userModel.getPassword_hash();
        String encryptedPassword = passwordEncoder.encode(password);

        UserModel newUser = new UserModel();
        newUser.setName(userModel.getName());
        newUser.setEmail(userModel.getEmail());
        newUser.setPassword_hash(encryptedPassword);
        newUser.setBio(userModel.getBio());
        newUser.setRole(userModel.getRole());
        newUser.setLocation(userModel.getLocation());
        newUser.setProfile_picture_url(userModel.getProfile_picture_url());

        return this.userRepository.save(newUser);
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
    public Optional<UserModel> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
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

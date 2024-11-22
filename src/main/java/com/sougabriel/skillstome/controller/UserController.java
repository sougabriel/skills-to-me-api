package com.sougabriel.skillstome.controller;

import com.sougabriel.skillstome.model.UserModel;
import com.sougabriel.skillstome.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceInterface.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceInterface.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userServiceInterface.save(userModel));
    }

    @PutMapping
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceInterface.update(userModel));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        this.userServiceInterface.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

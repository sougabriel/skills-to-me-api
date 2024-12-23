package com.sougabriel.skillstome.authentication.controller;

import com.sougabriel.skillstome.authentication.dto.LoginRequestDTO;
import com.sougabriel.skillstome.authentication.dto.RegisterRequestDTO;
import com.sougabriel.skillstome.authentication.dto.UserResponseDTO;
import com.sougabriel.skillstome.security.TokenService;
import com.sougabriel.skillstome.user.model.UserModel;
import com.sougabriel.skillstome.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        UserModel user = userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not Found!"));
        if (passwordEncoder.matches(body.password_hash(), user.getPassword_hash())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new UserResponseDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<UserModel> user = userRepository.findByEmail(body.email());
        if (user.isEmpty()) {
            UserModel newUser = new UserModel();
            newUser.setPassword_hash(passwordEncoder.encode(body.password_hash()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            newUser.setBio(body.bio());
            newUser.setLocation(body.location());
            newUser.setRole(body.role());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new UserResponseDTO(newUser.getEmail(), token));

        }
        return ResponseEntity.badRequest().build();
    }
}

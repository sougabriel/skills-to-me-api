package com.sougabriel.skillstome.authentication.dto;

import com.sougabriel.skillstome.user.model.UserRole;

public record RegisterRequestDTO (String email, String password_hash, String name, String bio, String location, UserRole role) {
}

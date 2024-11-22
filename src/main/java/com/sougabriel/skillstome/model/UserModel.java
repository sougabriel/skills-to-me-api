package com.sougabriel.skillstome.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "users", indexes = @Index(columnList = "email"))
public class UserModel {

    private enum UserRole {
        user,
        admin,
        moderator
    }

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false, length = 2000)
    private String bio;

    private String location;

    @Column(length = 2000)
    private String profile_picture_url;

    @Column(nullable = false)
    private UserRole role;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime updated_at = LocalDateTime.now();
}

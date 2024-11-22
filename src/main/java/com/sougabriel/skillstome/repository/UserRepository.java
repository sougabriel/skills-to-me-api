package com.sougabriel.skillstome.repository;

import com.sougabriel.skillstome.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}

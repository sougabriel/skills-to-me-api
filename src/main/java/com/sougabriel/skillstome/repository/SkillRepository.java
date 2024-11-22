package com.sougabriel.skillstome.repository;

import com.sougabriel.skillstome.model.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<SkillModel, UUID> {
}

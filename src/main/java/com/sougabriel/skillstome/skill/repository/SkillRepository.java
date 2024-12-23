package com.sougabriel.skillstome.skill.repository;

import com.sougabriel.skillstome.skill.model.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<SkillModel, UUID> {
}

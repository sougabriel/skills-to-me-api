package com.sougabriel.skillstome.repository;

import com.sougabriel.skillstome.model.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<SkillModel, String> {
}

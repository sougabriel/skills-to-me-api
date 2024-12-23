package com.sougabriel.skillstome.skill.service;

import com.sougabriel.skillstome.skill.model.SkillModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkillServiceInterface {

    SkillModel save(SkillModel skillModel);

    List<SkillModel> findAll();

    Optional<SkillModel> findById(UUID id);

    SkillModel update(SkillModel skillModel);

    void deleteById(UUID id);
}

package com.sougabriel.skillstome.service;

import com.sougabriel.skillstome.model.SkillModel;

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

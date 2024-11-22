package com.sougabriel.skillstome.service;

import com.sougabriel.skillstome.model.SkillModel;

import java.util.List;
import java.util.Optional;

public interface SkillService {

    SkillModel save(SkillModel skillModel);

    List<SkillModel> findAll();

    Optional<SkillModel> findById(String id);

    SkillModel update(SkillModel skillModel);

    void deleteById(String id);
}

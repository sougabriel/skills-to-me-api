package com.sougabriel.skillstome.service;

import com.sougabriel.skillstome.model.SkillModel;
import com.sougabriel.skillstome.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService implements SkillServiceInterface {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public SkillModel save(SkillModel skillModel) {
        return this.skillRepository.save(skillModel);
    }

    @Override
    public List<SkillModel> findAll() {
        return this.skillRepository.findAll();
    }

    @Override
    public Optional<SkillModel> findById(UUID id) {
        return this.skillRepository.findById(id);
    }

    @Override
    public SkillModel update(SkillModel skillModel) {
        return this.skillRepository.save(skillModel);
    }

    @Override
    public void deleteById(UUID id) {
        this.skillRepository.deleteById(id);
    }
}

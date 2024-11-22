package com.sougabriel.skillstome.service;

import com.sougabriel.skillstome.model.SkillModel;
import com.sougabriel.skillstome.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class SkillServiceImpl implements SkillService {

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
    public Optional<SkillModel> findById(String id) {
        return this.skillRepository.findById(id);
    }

    @Override
    public SkillModel update(SkillModel skillModel) {
        return this.skillRepository.save(skillModel);
    }

    @Override
    public void deleteById(String id) {
        this.skillRepository.deleteById(id);
    }
}

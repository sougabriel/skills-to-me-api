package com.sougabriel.skillstome.skill.controller;

import com.sougabriel.skillstome.skill.model.SkillModel;
import com.sougabriel.skillstome.skill.service.SkillServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillServiceInterface skillServiceInterface;

    @GetMapping
    public ResponseEntity<List<SkillModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.skillServiceInterface.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SkillModel>> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.skillServiceInterface.findById(id));
    }

    @PostMapping
    public ResponseEntity<SkillModel> create(@RequestBody SkillModel skillModel) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.skillServiceInterface.save(skillModel));
    }

    @PutMapping
    public ResponseEntity<SkillModel> update(@RequestBody SkillModel skillModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.skillServiceInterface.update(skillModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.skillServiceInterface.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package com.sougabriel.skillstome.controller;

import com.sougabriel.skillstome.model.SkillModel;
import com.sougabriel.skillstome.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.skillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SkillModel>> findById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.skillService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SkillModel> create(@RequestBody SkillModel skillModel) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.skillService.save(skillModel));
    }

    @PutMapping
    public ResponseEntity<SkillModel> update(@RequestBody SkillModel skillModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.skillService.update(skillModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        this.skillService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

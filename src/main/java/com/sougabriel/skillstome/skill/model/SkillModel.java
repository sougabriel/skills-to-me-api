package com.sougabriel.skillstome.skill.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "skills")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillModel {

    private enum SkillType {
        hardskill,
        softskill
    }

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Column(nullable = false, length = 9)
    private SkillType type;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime updated_at = LocalDateTime.now();
}

package com.sougabriel.skillstome.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Entity
public class SkillModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;
}

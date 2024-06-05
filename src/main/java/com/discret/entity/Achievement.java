package com.discret.entity;

import com.discret.entity.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "image_url")
    private String image;
    @Transient
    @ManyToMany(mappedBy = "achievements")
    private Set<Student> students;
}

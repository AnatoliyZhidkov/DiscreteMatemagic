package com.discret.entity;

import com.discret.entity.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "achievements")
    private List<Student> students;
}

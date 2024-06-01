package com.discret.entity.test;

import com.discret.entity.Student;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    private int score;

}
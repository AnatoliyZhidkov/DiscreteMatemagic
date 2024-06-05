package com.discret.entity.test;

import com.discret.entity.Student;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "testResult", cascade = CascadeType.ALL)
    private List<QuestionSession> questionSessions;

    private int score;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
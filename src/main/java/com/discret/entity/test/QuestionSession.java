package com.discret.entity.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class QuestionSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "test_result_id")
    private TestResult testResult;

    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question;

    @Size(max = 1000)
    private String generatedText;
    private String generatedData;
    private String correctAnswer;
    private String studentAnswer;
}


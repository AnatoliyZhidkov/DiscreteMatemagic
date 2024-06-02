package com.discret.entity.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class QuestionSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "test_result_id")
    private TestResult testResult;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String generatedText;
    private String generatedData;
    private String correctAnswer;

}

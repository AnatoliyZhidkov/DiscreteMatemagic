package com.discret.entity.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 1000)
    private String questionText;

    private String parameters;

    private int questionNumber;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;


    public Question(String questionText, String answerText, int questionNumber, Test test) {
        this.questionText = questionText;
        this.questionNumber = questionNumber;
        this.test = test;
        Answer answer = new Answer();
        answer.setAnswerText(answerText);
        answer.setCorrect(true);
        answer.setQuestion(this);

        this.answers = new ArrayList<>();
        this.answers.add(answer);

    }

    public Question() {

    }
}

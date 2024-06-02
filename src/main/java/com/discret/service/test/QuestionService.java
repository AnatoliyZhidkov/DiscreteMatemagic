package com.discret.service.test;

import com.discret.entity.Student;
import com.discret.entity.test.*;
import com.discret.repository.test.QuestionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {
    @PersistenceContext
    private EntityManager em;
    private final QuestionRepository questionRepository;
    private final TestService testService;
    private static final Random random = new Random();
    public List<QuestionSession> getGeneratedQuestions(int module, int testNumber, TestResult testResult) {

        Test test = testService.findTestByModuleAndNumber(module,testNumber);
        Long testId = test.getId();
        List<QuestionSession> questions = questionRepository.findAllByTestId(testId).stream().map(question -> generateQuestion(question, testResult)).collect(Collectors.toList());
        List<QuestionSession> questionSessions = new ArrayList<>();

        return questions;

    }



    private QuestionSession generateQuestion(Question question, TestResult testResult) {
        String text = question.getQuestionText();
        String[] params = question.getParameters().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String param : params) {
            if (!param.isEmpty()) {
                String[] range = param.split("-");
                int min = Integer.parseInt(range[0]);
                int max = Integer.parseInt(range[1]);
                int randomValue = random.nextInt((max - min) + 1) + min;
                numbers.add(randomValue);
                text = text.replaceFirst("\\{\\}", String.valueOf(randomValue));
            }
        }
        String generatedParam = numbers.stream().map(Objects::toString).collect(Collectors.joining(","));
        QuestionSession questionSession = new QuestionSession();

        questionSession.setQuestion(question);
        questionSession.setGeneratedData(text);
        questionSession.setTestResult(testResult);

        return questionSession;
    }
}

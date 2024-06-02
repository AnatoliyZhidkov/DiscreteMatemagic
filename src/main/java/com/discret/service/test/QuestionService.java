package com.discret.service.test;

import com.discret.entity.Student;
import com.discret.entity.test.Question;
import com.discret.entity.test.Test;
import com.discret.repository.test.QuestionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<Question> getGeneratedQuestions(int module, int testNumber) {

        Test test = testService.findTestByModuleAndNumber(module,testNumber);
        Long testId = test.getId();
        List<Question> questions = questionRepository.findAllByTestId(testId).stream().map(this::generateQuestion).collect(Collectors.toList());

        for (Question q : questions){

           // q.setAnswers();

        }

        return null;

    }



    private Question generateQuestion(Question question) {
        String text = question.getQuestionText();
        String[] params = question.getParameters().split(",");
        List<Integer> numbers = null;
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
        text = numbers.stream().map(Objects::toString).collect(Collectors.joining(","));
        Question generatedQuestion = new Question();
        generatedQuestion.setParameters(text);
        generatedQuestion.setId(question.getId());
        generatedQuestion.setQuestionText(text);
        return generatedQuestion;
    }
}

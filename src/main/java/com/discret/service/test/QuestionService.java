package com.discret.service.test;

import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.DTO.QuestionDTO;
import com.discret.entity.Student;
import com.discret.entity.test.*;
import com.discret.repository.test.AnswerRepository;
import com.discret.repository.test.QuestionRepository;
import com.discret.repository.test.QuestionSessionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {
    @PersistenceContext
    private EntityManager em;
    private final QuestionRepository questionRepository;
    private final TestService testService;
    private final QuestionSessionRepository questionSessionRepository;
    private final AnswerRepository answerRepository;
    private final AnswerGenerator answerGenerator;

    private static final Random random = new Random();
    @Transactional
    public List<QuestionSession> getGeneratedQuestions(int module, int testNumber, TestResult testResult) {

        Test test = testService.findTestByModuleAndNumber(module,testNumber);
        Long testId = test.getId();
        List<Question> questionsList = questionRepository.findAllByTestIdOrderByQuestionNumber(testId);
        List<QuestionSession> questionSessions = new ArrayList<>();

        for (Question question : questionsList) {
            QuestionSession questionSession = generateQuestion(questionSessions,question, testResult);
            questionSessions.add(questionSession);
        }

        return questionSessions;

    }

    private QuestionSession generateQuestion(List<QuestionSession> questionSessionList,Question question, TestResult testResult) {
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
        QuestionSession questionSession = new QuestionSession();
        questionSession.setQuestion(question);
        questionSession.setGeneratedText(text);

        questionSession.setGeneratedData(numbers.stream().map(Objects::toString).collect(Collectors.joining(",")));
        questionSession.setTestResult(testResult);
        questionSession.setCorrectAnswer(answerGenerator.generateAnswer(questionSessionList,questionSession,numbers));
        return questionSession;
    }

    @Transactional
    public QuestionSession findQuestionSessionById(Long id) {
        return questionSessionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No QuestionSession found with id " + id));
    }



    public boolean addQuestionsToTest(List<QuestionDTO> questions, Long testId) {

        Test test = testService.findById(testId);

        for (QuestionDTO questionDTO : questions) {
            String questionText = questionDTO.getQuestionText();
            String answerText = questionDTO.getAnswerText();
            int questionNumber = questionDTO.getQuestionNumber();
            Question newQuestion = new Question(questionText, answerText, questionNumber, test);
            questionRepository.save(newQuestion);
        }
        return true;

    }

    public List<Question> getQuestionsByTest(Long testId) {

        List<Question> questions = this.questionRepository.findAllByTestId(testId).orElseThrow(() -> new NoSuchElementException("No Question found with id " + testId));
        return questionRepository.findAllByTestId(testId).orElseThrow(() -> new NoSuchElementException("No Question found with id " + testId));
    }


    public Question findQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new NoSuchElementException("No Question found with id " + questionId));
    }

    public boolean updateQuestion(QuestionDTO questionDTO, Long questionId) {

        this.questionRepository.findById(questionId)
                .ifPresentOrElse(
                        question ->{
                            question.setQuestionText(questionDTO.getQuestionText());
                            question.setQuestionNumber(questionDTO.getQuestionNumber());

                            List<Answer> existingAnswers = this.answerRepository.findAllByQuestionId(questionId)
                                    .orElseThrow(() -> new NoSuchElementException("No Answer found with id " + questionId));

                            for (Answer existingAnswer : existingAnswers) {
                                existingAnswer.setAnswerText(questionDTO.getAnswerText());
                            }
                            this.questionRepository.save(question);
                        }
                        ,() -> {throw new NoSuchElementException();}
                            );

        return true;
    }

    public boolean deleteQuestion(Long questionId) {
        this.questionRepository.deleteById(questionId);
        return true;
    }
}

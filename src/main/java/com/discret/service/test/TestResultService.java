package com.discret.service.test;

import com.discret.DTO.AnswerDTO;
import com.discret.DTO.TestSubmissionDTO;
import com.discret.controllers.test.TestResultController;
import com.discret.entity.Student;
import com.discret.entity.test.QuestionSession;
import com.discret.entity.test.Test;
import com.discret.entity.test.TestResult;
import com.discret.repository.StudentsRepository;
import com.discret.repository.test.TestRepository;
import com.discret.repository.test.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestResultService {

   private final TestRepository testRepository;
   private final StudentsRepository studentsRepository;
   private final QuestionService questionService;
   private final TestResultRepository testResultRepository;



    public TestResult startTest(int Module,int testNumber, Student student) {

        Test test = testRepository.findByModuleAndAndNumber( Module, testNumber);
        //Student student = studentsRepository.findByLogin(studentLogin);

        TestResult testResult = new TestResult();
        testResultRepository.save(testResult);
        testResult.setTest(test);
        testResult.setStudent(student);
        testResult.setStartTime(LocalDateTime.now());
        testResult.setQuestionSessions(questionService.getGeneratedQuestions(Module,testNumber,testResult));


        return testResultRepository.save(testResult);
    }

    public List<Boolean> endTest(Long idTestResult, TestSubmissionDTO testSubmissionDTO) {

        TestResult testResult = testResultRepository.findById(idTestResult).orElseThrow(() -> new EntityNotFoundException("TestResult not found"));

        List<AnswerDTO> answers = testSubmissionDTO.getAnswers();
        List<Boolean> results = new ArrayList<>();

        for (AnswerDTO answer : answers) {
            QuestionSession questionSession = questionService.findQuestionSessionById(answer.getQuestionId());
            questionSession.setStudentAnswer(answer.getAnswer());
            boolean isCorrect = questionSession.getStudentAnswer().equals(questionSession.getCorrectAnswer());
            if (isCorrect) {
                testResult.setScore(testResult.getScore() + 1);
            }
            results.add(isCorrect);
        }

        testResult.setEndTime(LocalDateTime.now());
        this.testResultRepository.save(testResult);

        return results;
    }


    public List<TestResult> findAllByStudentId(Long studentId) {
        return testResultRepository.findAllByStudentId(studentId);
    }

    public boolean deleteTestResult(Long testResultId) {
       return this.testResultRepository.findById(testResultId).map(testResult -> {
           this.testResultRepository.delete(testResult);
           return true;
       }).orElseThrow(() -> new EntityNotFoundException("TestResult not found"));
    }

    public TestResult getLastScoreByTestModuleAndTestNumber(int module, int number, Long studentId) {

      return  this.testResultRepository

              .findLastByTestIdAndStudentId(testRepository.findByModuleAndAndNumber(module, number).getId(),studentId);

    }

    public List<Integer> findLatestTestResultsByModule(Student student, int moduleNumber) {

        List<Integer> results = new ArrayList<>();
        List<Test> tests = testRepository.findAllByModule(moduleNumber);
        for (Test test : tests) {
            TestResult result = testResultRepository.findLastByTestIdAndStudentId(test.getId(),student.getId());
            if (result != null) {
                results.add(result.getScore());
            }
            else {
                results.add(0);
            }
        }
        return results;


    }

}

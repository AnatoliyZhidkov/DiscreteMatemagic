package com.discret.service.test;

import com.discret.DTO.AnswerDTO;
import com.discret.DTO.TestSubmissionDTO;
import com.discret.controllers.test.TestResultController;
import com.discret.entity.Achievement;
import com.discret.entity.Student;
import com.discret.entity.test.QuestionSession;
import com.discret.entity.test.Test;
import com.discret.entity.test.TestResult;
import com.discret.repository.AchievementRepository;
import com.discret.repository.StudentsRepository;
import com.discret.repository.test.TestRepository;
import com.discret.repository.test.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestResultService {

   private final TestRepository testRepository;
   private final StudentsRepository studentsRepository;
   private final QuestionService questionService;
   private final TestResultRepository testResultRepository;
   private final AchievementRepository achievementRepository;

   @Transactional
    public TestResult startTest(int Module,int testNumber, Student student) {

        Test test = testRepository.findByModuleAndAndNumber( Module, testNumber);

        if (this.testResultRepository.existsByTestIdAndStudentId(test.getId(), student.getId())
                && testResultRepository.findLastByTestIdAndStudentId(test.getId(), student.getId()).getEndTime() == null) {
                return this.testResultRepository.findLastByTestIdAndStudentId(test.getId(), student.getId());
        }
        TestResult testResult = new TestResult();
        testResultRepository.save(testResult);
        testResult.setTest(test);
        testResult.setStudent(student);
        testResult.setStartTime(LocalDateTime.now());
        testResult.setQuestionSessions(questionService.getGeneratedQuestions(Module,testNumber,testResult));


        return testResultRepository.save(testResult);
    }
@Transactional
    public List<Boolean> endTest(Long idTestResult, TestSubmissionDTO testSubmissionDTO) {

        TestResult testResult = testResultRepository.findById(idTestResult).orElseThrow(() -> new EntityNotFoundException("TestResult not found"));



        List<AnswerDTO> answers = testSubmissionDTO.getAnswers();
        List<Boolean> results = new ArrayList<>();
        int score = 0;
        for (AnswerDTO answer : answers) {
            QuestionSession questionSession = questionService.findQuestionSessionById(answer.getQuestionId());
            questionSession.setStudentAnswer(answer.getAnswer());
            boolean isCorrect = questionSession.getStudentAnswer().toLowerCase().equals(questionSession.getCorrectAnswer());
            if (isCorrect) {
                score++;
            }
            results.add(isCorrect);
        }

        testResult.setScore(score);
        testResult.setEndTime(LocalDateTime.now());
        this.testResultRepository.save(testResult);

        return results;
    }

    public boolean existsByTestResultIdAndStudentId(Long testResultId,Long studentId) {
        return testResultRepository.existsByIdAndStudentId(testResultId,studentId);
    }

    @Transactional
    public List<TestResult> findAllByStudentId(Long studentId) {
        return testResultRepository.findAllByStudentId(studentId);
    }
    @Transactional
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

    @Transactional
    public int countTestResult(int module, int number, Long studentId) {
        return this.testResultRepository
                .countByTestIdAndStudentId(testRepository.findByModuleAndAndNumber(module, number).getId(),studentId);
    }

    @Transactional
    public List<Integer> findLatestTestResultsByModule(Student student, int moduleNumber) {

        List<Integer> results = new ArrayList<>();
        List<Test> tests = testRepository.findAllByModule(moduleNumber);
        for (Test test : tests) {
            TestResult result = testResultRepository.findLastByTestIdAndStudentId(test.getId(),student.getId());
            if (result != null) {
                int totalQuestions = test.getQuestion().size();
                int correctAnswers = result.getScore();
                int percentage = (correctAnswers * 100) / totalQuestions;
                results.add(percentage);
            }
            else {
                results.add(0);
            }
        }
        return results;
    }
   public TestResult findLastByTestResultIdAndStudentId (Long testResultId, Long studentId) {
       return testResultRepository.findLastByIdAndStudentId(testResultId,studentId);
   }

    @Transactional
    public List<Achievement> getAchievementsByStudent(Student student) {
        return student.getAchievements().stream().toList();
    }

    @Transactional
    public void checkAndAssignAchievements(Student student) {
        // Проверка на завершение первого модуля
        boolean firstModuleCompleted = testRepository.findAllByModule(1).stream()
                .allMatch(test -> testResultRepository.existsByTestIdAndStudentId(test.getId(), student.getId()));
        boolean secondModuleCompleted = testRepository.findAllByModule(2).stream()
            .allMatch(test -> testResultRepository.existsByTestIdAndStudentId(test.getId(), student.getId()));
        boolean thirdModuleCompleted = testRepository.findAllByModule(3).stream()
                .allMatch(test -> testResultRepository.existsByTestIdAndStudentId(test.getId(), student.getId()));
        boolean FourthModuleCompleted = testRepository.findAllByModule(4).stream()
                .allMatch(test -> testResultRepository.existsByTestIdAndStudentId(test.getId(), student.getId()));


        if (firstModuleCompleted) {
            assignAchievement(student, "Комбинаторный Пионер","/images/achieve2.svg", "За успешное завершение всех тестов модуля 1");
        }

    if (thirdModuleCompleted) {
        assignAchievement(student, "Исследователь Графов","/images/achieve4.svg","За успешное завершение всех тестов модуля 3");
    }
    if (FourthModuleCompleted) {
        assignAchievement(student, "Мастер Графов","/images/achieve4.1.svg","За успешное завершение всех тестов модуля 4");
    }
    if (secondModuleCompleted) {
        assignAchievement(student, "Комбинаторный Эксперт","/images/achieve3.svg","За успешное завершение всех тестов модуля 2");
    }


    }

    private void assignAchievement(Student student, String name, String image, String description) {
        Optional<Achievement> optionalAchievement = Optional.ofNullable(achievementRepository.findByName(name));
        Achievement achievement;
        if (optionalAchievement.isPresent()) {
            achievement = optionalAchievement.get();
        } else {
            achievement = new Achievement();
            achievement.setName(name);
            achievement.setImage(image);
            achievement.setDescription(description);
            achievement = achievementRepository.save(achievement);
        }

        if (!student.getAchievements().contains(achievement)) {
            student.getAchievements().add(achievement);
            studentsRepository.save(student);
        }
    }
    @Transactional
    public void deleteTestResultsByModuleAddTest(int moduleNumber, int testNumber, Long studentId) {

        testResultRepository.deleteByTestIdAndStudentId(testRepository.findByModuleAndAndNumber(moduleNumber, testNumber).getId(),studentId);
    }
}

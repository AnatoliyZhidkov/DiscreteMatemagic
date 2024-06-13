package com.discret.controllers.test;

import com.discret.DTO.AnswerDTO;
import com.discret.DTO.QuestionDTO;
import com.discret.DTO.TestSubmissionDTO;
import com.discret.entity.Student;
import com.discret.entity.test.Partition;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import com.discret.entity.test.TestResult;
import com.discret.repository.test.TestResultRepository;
import com.discret.service.test.QuestionService;
import com.discret.service.test.TestResultService;
import com.discret.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor

public class TestController {

    private final TestResultService testResultService;
    private final TestService testService;
    private final QuestionService questionService;



    @GetMapping("/tests/{module}/{testnumber}")
    public String startTest(@PathVariable("testnumber") int testnumber,
                           @PathVariable ("module") int module, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student) authentication.getPrincipal();

        if (this.testResultService.countTestResult(module, testnumber,student.getId()) >2) {
            if(student.getRoles().stream().anyMatch(s -> s.getAuthority().equals("ROLE_STUDENT"))){
                return "redirect:/main";
            }
        }

        TestResult testResult = testResultService.startTest(module,testnumber,student);
        List<QuestionSession> questions = testResult.getQuestionSessions();
        model.addAttribute("questions", questions);
        return String.format("tests/module%d/test%d-%d", module, module, testnumber);
    }

    @PostMapping("/tests/submitTest")
    public String submitTest(TestSubmissionDTO testSubmissionDTO,Long testResultId ,Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student) authentication.getPrincipal();

        if (this.testResultService.existsByTestResultIdAndStudentId(testResultId,student.getId()) && this.testResultService.findLastByTestResultIdAndStudentId(testResultId,student.getId()).getEndTime() != null) {
            return "redirect:/main";
        }

        model.addAttribute("results", this.testResultService.endTest(testResultId,testSubmissionDTO));
        this.testResultService.checkAndAssignAchievements(student);;
        return "tests/resultPage";

    }


    @GetMapping("/tests/{partitonId}")
    public String getTestsList(@PathVariable("partitonId") Long partitonId, Model model) {
        model.addAttribute("partitionId", partitonId);
        model.addAttribute("customTests", this.testService.findAllTestsByPartitionId(partitonId));
        return "adminPanel/testsList";
    }

    @GetMapping("/tests/{partitionId}/addTest")
    public String getAddTestPage(@PathVariable("partitionId") Long partitionId,Model model) {
        model.addAttribute("partitionId", partitionId);
        return "adminPanel/addTest";
    }

    @PostMapping("/tests/{partitionId}/addTest")
    public String addTest(@PathVariable("partitionId") Long partitionId, String name, int number) {
        this.testService.addTest(name,number,partitionId);
        return "redirect:/tests/"+partitionId;
    }

    @PostMapping("/tests/addQuestions")
    public ResponseEntity<String> addQuestions(@RequestHeader Long testId, @RequestBody List<QuestionDTO> questions) {

        questionService.addQuestionsToTest(questions, testId);
        return ResponseEntity.ok("{\"message\":\"Questions added successfully\"}");
    }

    @GetMapping("/tests/addQuestions/{testId}")
    public String showAddQuestionsForm(@PathVariable("testId") Long testId, Model model) {
        model.addAttribute("partitionId", this.testService.findById(testId).getPartition().getId());
        model.addAttribute("testId", testId);
        return "adminPanel/addQuestions";
    }


    @PostMapping("/tests/delete")
    public String deleteTest(Long testId, Long partitionId) {
        this.testService.deleteTest(testId);
        return "redirect:/tests/" + partitionId;
    }




}

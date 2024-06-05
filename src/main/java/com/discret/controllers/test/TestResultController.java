package com.discret.controllers.test;

import com.discret.entity.Student;
import com.discret.entity.test.TestResult;
import com.discret.repository.StudentsRepository;
import com.discret.repository.test.TestResultRepository;
import com.discret.service.StudentService;
import com.discret.service.test.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestResultController {

    private final TestResultService testResultService;
    private final StudentService studentService;

    @GetMapping("/testResult/{studentId}")
    public String testResult(@PathVariable("studentId") Long studentId, Model model){
        Student student = studentService.findStudentById(studentId);
        for (int moduleNumber = 1; moduleNumber <= 4; moduleNumber++) {
            List<Integer> testResults = testResultService.findLatestTestResultsByModule(student, moduleNumber);
            model.addAttribute("module" + moduleNumber + "Results", testResults);
        }
        List<TestResult> testResults = testResultService.findAllByStudentId(studentId);
        if (testResults.isEmpty()) {
            return "redirect:/admin";
        }
        model.addAttribute("testResults", testResults);
        testResults.get(0).getQuestionSessions().size();
        return "adminPanel/testResult";
    }

    @PostMapping("/testResult/deleteResult")
    public String deleteResult(@RequestParam Long resultId, @RequestParam Long studentId) {
        testResultService.deleteTestResult(resultId);

        return "redirect:/testResult/%d".formatted(studentId); // Перенаправление на страницу с результатами
    }





}

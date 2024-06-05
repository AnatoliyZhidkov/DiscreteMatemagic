package com.discret.controllers;

import com.discret.entity.Student;
import com.discret.entity.test.TestResult;
import com.discret.service.test.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProgressController {
    private final TestResultService testResultService;
    @GetMapping("/progress")
    public String progress( Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student)authentication.getPrincipal();

        for (int moduleNumber = 1; moduleNumber <= 4; moduleNumber++) {
            List<Integer> testResults = testResultService.findLatestTestResultsByModule(student, moduleNumber);
            model.addAttribute("module" + moduleNumber + "Results", testResults);
        }

        return "progress";
    }


}

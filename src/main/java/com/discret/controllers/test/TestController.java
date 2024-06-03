package com.discret.controllers.test;

import com.discret.DTO.AnswerDTO;
import com.discret.DTO.TestSubmissionDTO;
import com.discret.entity.Student;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import com.discret.entity.test.TestResult;
import com.discret.repository.test.TestResultRepository;
import com.discret.service.test.QuestionService;
import com.discret.service.test.TestResultService;
import com.discret.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;
    private final QuestionService questionService;

    private final TestResultRepository testResultRepository;
    private final TestResultService testResultService;


    @GetMapping("/{module}/{testnumber}")
    public String startTest(@PathVariable("testnumber") int testnumber,
                           @PathVariable ("module") int module, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student) authentication.getPrincipal();
        TestResult testResult = testResultService.startTest(module,testnumber,student);

        List<QuestionSession> questions = testResult.getQuestionSessions();
        model.addAttribute("questions", questions);


        return String.format("/tests/module%d/test%d-%d", module, module, testnumber);
    }


    @PostMapping("/submitTest")
    public String submitTest(TestSubmissionDTO testSubmissionDTO,Long testResultId ,Model model) {

        List<AnswerDTO> answers = testSubmissionDTO.getAnswers();
        List<Boolean> results = new ArrayList<>();

        for (AnswerDTO answer : answers) {
            QuestionSession questionSession = questionService.findQuestionSessionById(answer.getQuestionId());
            questionSession.setStudentAnswer(answer.getAnswer());
            boolean isCorrect = questionSession.getStudentAnswer().equals(questionSession.getCorrectAnswer());
            results.add(isCorrect);
        }





        model.addAttribute("results", results);
        return "tests/resultPage"; // Вернуть страницу с результатами


    }

}

package com.discret.controllers.test;


import com.discret.DTO.QuestionDTO;
import com.discret.entity.test.Partition;
import com.discret.entity.test.Question;
import com.discret.service.test.PatitionService;
import com.discret.service.test.QuestionService;
import com.discret.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final TestService testService;
    @GetMapping("/tests/{testId}/questionList")
    public String getQuestionList(@PathVariable("testId") Long testId, Model model) {
        model.addAttribute("partitionId", this.testService.findById(testId).getPartition().getId());
        model.addAttribute("questions", questionService.getQuestionsByTest(testId));

        return "adminPanel/questionList";
    }
    @GetMapping("/tests/{testId}/addQuestion")
    public String showAddQuestionForm(@PathVariable("testId") Long testId, Model model) {
        model.addAttribute("testId", testId);
        return "adminPanel/addQuestion";
    }
    @PostMapping("/tests/{testId}/addQuestion")
    public String addQuestion(@PathVariable("testId") Long testId,@ModelAttribute QuestionDTO questionData) {

        List<QuestionDTO> questionList = new ArrayList<>();
        questionList.add(questionData);
        this.questionService.addQuestionsToTest(questionList, testId);

        return "redirect:/tests/%d/questionList".formatted(testId);
    }
    @GetMapping("/tests/{testId}/updateQuestion/{questionId}")
    public String showUpdateForm(@PathVariable("testId") Long testId, @PathVariable("questionId") Long questionId, Model model) {
        Question question = questionService.findQuestionById(questionId);
        model.addAttribute("question", question);
        model.addAttribute("testId", testId);
        return "adminPanel/updateQuestion";
    }
    @PostMapping("/tests/{testId}/updateQuestion/{questionId}")
    public String updateQuestion(@PathVariable("testId") Long testId, @PathVariable("questionId") Long questionId, @ModelAttribute QuestionDTO question) {

        questionService.updateQuestion(question, questionId);
        return "redirect:/tests/%d/questionList".formatted(testId);
    }
    @PostMapping("/tests/{testId}/deleteQuestion/{questionId}")
    public String deleteQuestion(@PathVariable("testId") Long testId, @PathVariable("questionId") Long questionId) {
        questionService.deleteQuestion(questionId);
        return "redirect:/tests/%d/questionList".formatted(testId);
    }
}

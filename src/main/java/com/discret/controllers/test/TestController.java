package com.discret.controllers.test;

import com.discret.entity.test.Question;
import com.discret.service.test.QuestionService;
import com.discret.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;
    private final QuestionService questionService;
    @GetMapping("/{module}/{testnumber}")
    public String showTest(@PathVariable("testnumber") int testnumber,
                           @PathVariable ("module") int module, Model model,  Principal principal) {

        List<Question> questions = questionService.getGeneratedQuestions(module,testnumber);
        model.addAttribute("question", questions);


        return String.format("/tests/module%d/test%d-%d", module, module, testnumber);
    }

}

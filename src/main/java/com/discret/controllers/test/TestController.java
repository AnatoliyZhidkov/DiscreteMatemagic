package com.discret.controllers.test;

import com.discret.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {
    private TestService testService;

    @GetMapping("/{testId}")
    public String showTest(@PathVariable Long testId, Model model, Principal principal) {


        return "tests/module1/test1-1";
    }

}

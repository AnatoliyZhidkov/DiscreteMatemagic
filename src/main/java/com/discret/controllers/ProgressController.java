package com.discret.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ProgressController {
    @GetMapping("/progress")
    public String progress(){
        return "progress";
    }
}

package com.discret.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Model model){
        return "main";
    }

    @GetMapping("/")
    public String defaultPage(){
        return "redirect:/main";
    }





}

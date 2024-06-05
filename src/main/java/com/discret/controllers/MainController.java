package com.discret.controllers;

import com.discret.entity.Student;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Collection;
import java.util.NoSuchElementException;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student)authentication.getPrincipal();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("hasAdminRole", hasAdminRole);

        model.addAttribute("loginName", student.getLogin());
        return "main";
    }

    @GetMapping("/")
    public String defaultPage(){
        return "redirect:/main";
    }





}

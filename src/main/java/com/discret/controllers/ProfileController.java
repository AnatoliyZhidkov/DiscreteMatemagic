package com.discret.controllers;

import com.discret.entity.Student;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {


    @GetMapping("/profile")
    public String profile(Model model){
        //TODO Сделать отправку в теле запроса
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student)authentication.getPrincipal();
        String groupFullName = student.getStudent_groups().getGroupname() +"-"+ String.valueOf(student.getStudent_groups().getGroupNumber());
        String studenFullName = student.getLastName() +" " +student.getFirstName()+" "+student.getMiddleName();
        model.addAttribute("fullName", studenFullName);
        model.addAttribute("groupName", groupFullName);
        model.addAttribute("loginName", student.getLogin());
        return "profile";
    }
}

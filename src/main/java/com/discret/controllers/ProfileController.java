package com.discret.controllers;

import com.discret.entity.Achievement;
import com.discret.entity.Student;
import com.discret.service.student.StudentService;
import com.discret.service.test.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProfileController {
    private final TestResultService testResultService;
    private final StudentService studentService;

    @GetMapping("/profile")
    public String profile(Model model){
        //TODO Сделать отправку в теле запроса
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student)authentication.getPrincipal();
        String groupFullName = student.getStudent_groups().getGroupname() +"-"+ String.valueOf(student.getStudent_groups().getGroupNumber());
        String studenFullName = student.getLastName() +" " +student.getFirstName()+" "+student.getMiddleName();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("hasAdminRole", hasAdminRole);
        List<Achievement> achievements = testResultService.getAchievementsByStudent(student);
        model.addAttribute("achievements", achievements);
        model.addAttribute("fullName", studenFullName);
        model.addAttribute("groupName", groupFullName);
        model.addAttribute("loginName", student.getLogin());
        return "profile";
    }

    @PostMapping("/profile/changePassword")
    public String changePassword(String oldPassword, String newPassword, String newPasswordConfirm){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student)authentication.getPrincipal();
        boolean a = studentService.checkPassword(student, oldPassword);
        if (!studentService.checkPassword(student, oldPassword) || !newPassword.equals(newPasswordConfirm)) {
            return "redirect:/profile";
        }

        studentService.changePassword(student, newPassword);
        return "redirect:/profile";

    }



}

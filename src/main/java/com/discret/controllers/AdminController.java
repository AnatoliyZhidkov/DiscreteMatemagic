package com.discret.controllers;

import com.discret.controllers.payload.NewStudentPayload;
import com.discret.repository.StudentsRepository;
import com.discret.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final StudentService studentService;

    @GetMapping("/admin")
    public String studentList(Model model){
        model.addAttribute("student",studentService.allStudents());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteStudent(@RequestParam(required = true, defaultValue = "") Long studentId,
                                @RequestParam(required = true, defaultValue = "") String action, Model model){
        if(action.equals("delete")){
        studentService.deleteStudent(studentId);
        }

        return "redirect:admin";
    }
    @PostMapping("/admin/create")
    public String createStudent(NewStudentPayload payload,Model model){

        //Student student = this.studentService.saveStudent(payload.)
        return "admin";
    }

    @GetMapping("/admin/get/{studentId}")
    public String getStudent(@PathVariable("studentId") Long studentId, Model model){
        model.addAttribute("allStudents", studentService.studentGetList(studentId));
        return "admin";
    }

}

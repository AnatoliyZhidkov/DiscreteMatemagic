package com.discret.controllers;

import com.discret.controllers.payload.NewStudentPayload;
import com.discret.entity.Student;
import com.discret.repository.StudentsGroupsRepository;
import com.discret.repository.StudentsRepository;
import com.discret.service.StudentGroupsService;
import com.discret.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final StudentService studentService;

    private final StudentGroupsService studentGroupsService;

    @GetMapping("/admin")
    public String studentList(Model model){
        model.addAttribute("student",studentService.allStudents());
        model.addAttribute("groups", studentGroupsService.findAllGroups());
        return "adminPanel/admin";
    }

    @PostMapping("/admin/delete")
    public String deleteStudent(@RequestParam(required = true, defaultValue = "") Long studentId,
                                @RequestParam(required = true, defaultValue = "") String action, Model model){
        if(action.equals("delete")){
        studentService.deleteStudent(studentId);
        }

        return "redirect:/admin";
    }
    @GetMapping("/admin/create")
    public String getNewStudentPage(Model model){
        model.addAttribute("groups", studentGroupsService.findAllGroups());
        return "adminPanel/new_student";}
    @PostMapping("/admin/create")
    public String createStudent(String login,String password, String lastName,String firstName, String middleName,Long groupId,String role,Model model){

        studentService.createStudent(login, password, lastName, firstName, middleName, role,groupId);
        return "redirect:/admin";
    }

    @GetMapping("/admin/get/{groupId}")
    public String getStudent(@PathVariable("groupId") Long groupId, Model model){
        List<Student> students = studentService.studentGetListByGroup(groupId);
        model.addAttribute("student", studentService.studentGetListByGroup(groupId));
        return "adminPanel/admin";
    }
    @GetMapping("/admin/create/group")
    public String getNewGroupPage(){
        return "adminPanel/new_group";
    }
    @PostMapping("/admin/create/group")
    public String createGroup(String groupname, int groupNumber){
        studentGroupsService.createGroup(groupname,groupNumber);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete/group")
    public String deleteGroup(@RequestParam(required = true, defaultValue = "") String groupname,
                              @RequestParam(required = true, defaultValue = "") int groupNumber,
                              @RequestParam(required = true, defaultValue = "") String action, Model model){

        if(action.equals("delete")){
            studentGroupsService.deleteGroup(groupname,groupNumber);
        }

        return "redirect:/admin";
    }

}

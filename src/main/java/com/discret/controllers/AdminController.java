package com.discret.controllers;

import com.discret.entity.Student;
import com.discret.service.student.StudentGenetateService;
import com.discret.service.student.StudentGroupsService;
import com.discret.service.student.StudentService;
import lombok.RequiredArgsConstructor;
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
    private final StudentGenetateService studentGenetateService;

    @GetMapping("/admin")
    public String studentList(Model model){
        model.addAttribute("student",studentService.allStudents());
        model.addAttribute("groups", studentGroupsService.findAllGroups());
        return "adminPanel/admin";
    }

    @PostMapping("/admin/delete")
    public String deleteStudent(@RequestParam(required = true, defaultValue = "") Long studentId,
                                @RequestParam(required = true, defaultValue = "") String action, Model model){

        if(studentService.findStudentById(studentId).getRoles().stream().anyMatch(s -> s.getAuthority().equals("ROLE_ADMIN"))){
            return "redirect:/admin";
        }

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

        studentService.saveStudent(login, password, lastName, firstName, middleName, role,groupId);
        return "redirect:/admin";
    }

    @GetMapping("/admin/get/{groupId}")
    public String getStudent(@PathVariable("groupId") Long groupId, Model model){
        List<Student> students = studentService.studentGetListByGroup(groupId);
        model.addAttribute("student", studentService.studentGetListByGroup(groupId));
        return "adminPanel/studentsList";
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

        if(groupname == "admin"){
            return "redirect:/admin";
        }

        if(action.equals("delete")){
            studentGroupsService.deleteGroup(groupname,groupNumber);
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin/update/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId, Model model){

        model.addAttribute("student", studentService.findStudentById(studentId));
        model.addAttribute("groups", studentGroupsService.findAllGroups());
        return "adminPanel/update_student";
    }

    @PostMapping("/admin/update/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,String login,String password, String lastName,String firstName, String middleName,Long groupId,String role,Model model){

        studentService.updateStudent(studentId,login, password, lastName, firstName, middleName, role,groupId);
        return "redirect:/admin";
    }

    @GetMapping("/admin/addStudents/{groupId}")
    public String getAddStudentsPage(@PathVariable("groupId") Long groupId, Model model){
        model.addAttribute("groupId",groupId);

        return "adminPanel/addStudents";
    }


    @PostMapping("/admin/addStudents/{groupId}")
    public String addStudents(String studentsList,@PathVariable("groupId") Long groupId, Model model){ {

        model.addAttribute("studentsList",studentsList);
        model.addAttribute("students",studentGenetateService.addStudents(studentsList,groupId));
        return "adminPanel/addStudents";
    }




    }







}

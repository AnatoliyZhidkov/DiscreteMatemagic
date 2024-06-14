package com.discret.controllers.test;

import com.discret.entity.Student;
import com.discret.entity.test.Partition;
import com.discret.service.student.StudentService;
import com.discret.service.test.PatitionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor

public class PartitionController {
    private final PatitionService patitionService;
    private final StudentService studentService;

    @GetMapping("/tests/addPartition")
    public String getAddPartition() {
        return "adminPanel/addPartition";
    }


    @PostMapping("/tests/addPartition")
    public String addPartition(String partition) {

        patitionService.savePartition(partition);

        return "redirect:/admin";
    }


    @GetMapping("/partitions")

    public String getPartitions(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student)authentication.getPrincipal();

        model.addAttribute("partitions", patitionService.findAll());
        return "partitionList";
    }

}

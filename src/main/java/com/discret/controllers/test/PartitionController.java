package com.discret.controllers.test;

import com.discret.entity.test.Partition;
import com.discret.service.test.PatitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class PartitionController {
    private final PatitionService patitionService;

    @GetMapping("/tests/addPartition")
    public String getAddPartition() {
        return "adminPanel/addPartition";
    }


    @PostMapping("/tests/addPartition")
    public String addPartition(String partition) {

        patitionService.savePartition(partition);

        return "redirect:/admin";
    }

}

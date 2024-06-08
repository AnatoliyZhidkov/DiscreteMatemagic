package com.discret.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller

public class TheoryController {

    @GetMapping("module/{mId}/theory/{thId}")
    public String theory(@PathVariable("mId") int mId
                        ,@PathVariable("thId") int thId){

        return String.format("theories/module%d/theory%d-%d", mId, mId, thId);
    }


}

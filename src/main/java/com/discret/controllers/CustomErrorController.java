//package com.discret.controllers;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.Map;
////@RequiredArgsConstructor
//@Controller
//public class CustomErrorController implements ErrorController {
//
//    private final ErrorAttributes errorAttributes;
//
//    public CustomErrorController() {
//        this.errorAttributes = new DefaultErrorAttributes();
//    }
//
//
//    @RequestMapping("/error")
//    public String handleError(WebRequest webRequest, Model model) {
//        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
//        model.addAttribute("timestamp", errorAttributes.get("timestamp"));
//        model.addAttribute("status", errorAttributes.get("status"));
//        model.addAttribute("error", errorAttributes.get("error"));
//        model.addAttribute("message", errorAttributes.get("message"));
//        model.addAttribute("path", errorAttributes.get("path"));
//        return "errors/404";
//    }
//
//}
package com.mohaji.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String mainTest(Model model){
        model.addAttribute("text", "정상작동됩니다.");
        return "test";
    }

    @GetMapping("/test")
    public String index(Model model){
        model.addAttribute("text", "정상작동됩니다.");
        return "login/index";
    }
}

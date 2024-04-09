package com.mohaji._sb0408commandobject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(){
        return "main";
    }

    @GetMapping("/main")
    public String index1(){
        return "main";
    }

    @ModelAttribute
    public void case1(Model model){
        model.addAttribute("value1","헤이");
    }

    @ModelAttribute("value2")
    public String case2(){
        return "할로.";
    }
}

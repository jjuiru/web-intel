package com.mohaji._sb0408commandobject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}

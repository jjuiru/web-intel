package com.mohaji.mohaji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//mypage
@Controller
public class MyController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

//regStat
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/myPage")
    public String myPage(){
        return "myPage";
    }

}

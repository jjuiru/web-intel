package com.mohaji.dockertest2.controller;

import com.mohaji.dockertest2.mapper.MemberMapper;
import com.mohaji.dockertest2.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

@Autowired
public MemberMapper memberMapper;

    @RequestMapping("/")

    public String index(Model model){
        int count = memberMapper.countMembers();
        model.addAttribute("memberCount",count);

        return "index";


    }

}

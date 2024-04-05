package com.mohaji._sb0401.controller;

import com.mohaji._sb0401.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 일반 컨트롤러는 오류발생 , 레스트를 쓰면 리턴문자를 출력한다.
public class MyController {

    @Autowired
    MemoService memoService;

    @GetMapping("/")
    public String root(){
        memoService.emInsert();
        return "main";
    }
}

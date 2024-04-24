package com.mohaji._sb0423.practice.controller;


import com.mohaji._sb0423.practice.dto.InputRequest;
import com.mysql.cj.util.DnsSrv;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/practice")
public class MyController {

    @GetMapping
    public String form(Model model){
        model.addAttribute("inputRequest", new InputRequest());
        return "practice/form";
    }

    @PostMapping
    public String result(@Valid InputRequest inputRequest, Errors errors){
        //result 로 값 내리는 방법 model 대신 inputRequest를 사용할 수 있다.
        //Errors와 대상이 되는 값 앞에 @Valid 어노테이션으로 검증한다. dto에서 name은 비면 안되기 때문에 오류발생
        if (errors.hasErrors()){ // 에러가 있다면 폼으로 돌아가는 코드
            return "practice/form";
        }
        return "practice/result";
    }
}

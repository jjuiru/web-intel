package com.mohaji.bootwebapp2.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("Say-Hello")
    @ResponseBody
    public String index(){
        return "Hello!!!";
    }
}

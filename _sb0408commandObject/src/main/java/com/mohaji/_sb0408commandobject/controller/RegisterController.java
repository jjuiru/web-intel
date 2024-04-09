package com.mohaji._sb0408commandobject.controller;

import com.mohaji._sb0408commandobject.spring.DuplicateMemberException;
import com.mohaji._sb0408commandobject.spring.MemberRegisterService;
import com.mohaji._sb0408commandobject.spring.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private MemberRegisterService memberRegisterService;

	@RequestMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			System.out.println("DuplicateMemberException");
			return "register/step2";
		}
	}

@ModelAttribute
public void case1(Model model){
		model.addAttribute("value1","안녕하세요");
	}

	@ModelAttribute("value2")
	public String case2(){
		return "반갑습니다.";
	}
}

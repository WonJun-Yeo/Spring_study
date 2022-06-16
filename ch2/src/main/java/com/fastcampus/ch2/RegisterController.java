package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//프로그램 등록
@Controller
public class RegisterController {
	// URL 연결
	@RequestMapping("/register/add")
	public String register() {
		return "registerForm";		// WEB-INF/views/regusterForm.jsp
	}
	
	// URL 연결
	@RequestMapping("/register/save")
	public String save() {
		return "registerInfo";
	}
}

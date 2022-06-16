package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//���α׷� ���
@Controller
public class RegisterController {
	// URL ����
	@RequestMapping("/register/add")
	public String register() {
		return "registerForm";		// WEB-INF/views/regusterForm.jsp
	}
	
	// URL ����
	@RequestMapping("/register/save")
	public String save() {
		return "registerInfo";
	}
}

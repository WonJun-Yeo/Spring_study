package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//프로그램 등록
@Controller
public class RegisterController {
	// URL 연결
	// @RequestMapping(value="/register/add", method=RequestMethod.POST)
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";		// WEB-INF/views/regusterForm.jsp
//	}
	
	// URL 연결
	// @RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
			//return "redirect:/register/add?msg=" + msg;			// URL 재작성 : rewriting
		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}

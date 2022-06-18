package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1. ������ ����
		session.invalidate();
		
		// 2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(@CookieValue("id") String cookieId, String id, String pwd, String toURL, boolean rememberId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		// 1. id�� pwd Ȯ��
		if (!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			
			// 2-1. ��ġ���� ������, loginForm���� �̵�
			return "redirect:/login/login?msg=" + msg;
		}
		
		// 2-2. id�� pwd�� ��ġ�ϸ�, Ȩ���� �̵�
			// ���� ��ü ������
		HttpSession session = request.getSession();
		
			// ���� ��ü�� id�� ����
		session.setAttribute("id", id);
		
			// 1. ��Ű ����
			// 2. ���信 ����
			// 3. Ȩ���� �̵�
		
		if (rememberId) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:/" + toURL;
	}
	
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}

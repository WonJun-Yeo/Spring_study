package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10;	// 인스턴스 변수
	static int cv = 20;		// static 변수
	
	@RequestMapping("/hello")
	private void main() {
		System.out.println("Hello");
		System.out.println(cv);
		System.out.println(iv);
	}
	
	// static 메서드는 static 변수만 사용이 가능하다.
	public static void main2() {
		System.out.println(cv);		// 사용가능
		//System.out.println(iv);	// 에러
	}
}

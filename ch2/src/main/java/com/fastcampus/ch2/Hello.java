package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	int iv = 10;	// �ν��Ͻ� ����
	static int cv = 20;		// static ����
	
	@RequestMapping("/hello")
	private void main() {
		System.out.println("Hello");
		System.out.println(cv);
		System.out.println(iv);
	}
	
	// static �޼���� static ������ ����� �����ϴ�.
	public static void main2() {
		System.out.println(cv);		// ��밡��
		//System.out.println(iv);	// ����
	}
}

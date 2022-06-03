package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloSurvlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 서블릿이 초기화될 때 자동 호출되는 메소드
		// 1. 서블릿의 초기화 작업 담당
		System.out.println("HelloServlet init() is called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입력
		// 2. 처리
		// 3. 출력
		System.out.println("HelloServlet service() is called");
	}
	
	@Override
	public void destroy() {
		// 서블릿이 메모리에서 리로딩되거나 웹애플리케이션이 종료될 때, 뒷마무리를 하기위해 서블릿 컨테이너에 의해 자동 호출된다.
		System.out.println("HelloServlet destroy() is called");
	}

	
}

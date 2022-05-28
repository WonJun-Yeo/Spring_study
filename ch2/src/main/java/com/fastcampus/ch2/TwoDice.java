package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	// 실행할 때마다 결과가 달라지는 것을 동적 리소스라고 한다.
    //    public static void main(String[] args) {
	@RequestMapping("/rollDice")
    public void main(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		int idx1 = (int)(Math.random()*6)+1;
        int idx2 = (int)(Math.random()*6)+1;

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='./resources/img/dice"+idx1+".jpg'>");
        out.println("<img src='./resources/img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
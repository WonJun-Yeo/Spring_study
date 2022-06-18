package com.fastcampus.ch2;

import java.io.FileNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice 모든 패키지에 적용
@ControllerAdvice("com.fastcampus.ch3")	// 지정한 패키지에만 적용
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		return "error";
	}
	
}

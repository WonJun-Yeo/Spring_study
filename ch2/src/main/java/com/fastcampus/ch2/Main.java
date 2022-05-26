package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
		// 메서드를 private으로 설정하면 다른 클래스에서 메서드 호출이 불가능
		// Hello hello = new Hello();
		// hello.main();
		
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		// java.lang.reflect 패키지 제공
		
		
		// Hello클래스의 Class 객체 (클래스의 정보를 담고 있는 객체)를 얻어온다.
		// 클래스 파일(*.class)이 메모리에 올라갈 때, 클래스 파일마다 Class 객체가 하나씩 생성된다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		// Class 객체가 가진 정보로 객체 생성
		Hello hello = (Hello) helloClass.newInstance();
		
		// private인 main()을 호출가능하게 한다.
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);
		
		// hello.main() 호출
		main.invoke(hello);
		
	}

}

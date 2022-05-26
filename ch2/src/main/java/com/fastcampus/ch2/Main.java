package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
		// �޼��带 private���� �����ϸ� �ٸ� Ŭ�������� �޼��� ȣ���� �Ұ���
		// Hello hello = new Hello();
		// hello.main();
		
		// Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
		// java.lang.reflect ��Ű�� ����
		
		
		// HelloŬ������ Class ��ü (Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		// Ŭ���� ����(*.class)�� �޸𸮿� �ö� ��, Ŭ���� ���ϸ��� Class ��ü�� �ϳ��� �����ȴ�.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		// Class ��ü�� ���� ������ ��ü ����
		Hello hello = (Hello) helloClass.newInstance();
		
		// private�� main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);
		
		// hello.main() ȣ��
		main.invoke(hello);
		
	}

}

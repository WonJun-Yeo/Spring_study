package com.fastcampus.ch3.aop;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception {
        MyAdvice myAdvice = new MyAdvice();

        Class myCless = Class.forName("com.fastcampus.ch3.aop.MyClass");
        Object obj = myCless.newInstance();

        for (Method m : myCless.getDeclaredMethods()) {
            myAdvice.invoke(m, obj, null);
        }
    }
}

class MyAdvice {
    Pattern p = Pattern.compile("a.*");

    boolean matches(Method m) {
        Matcher matcher = p.matcher(m.getName());
        return matcher.matches();
    }

    void invoke(Method m, Object obj, Object...args) throws Exception {
        if (matches(m))
            System.out.println("[before]");

        m.invoke(obj, args);    // aaa(), bbb(), ccc()

        if (matches(m))
            System.out.println("[after]");
    };
}

class MyClass {
    void aaa() {
        System.out.println("aaa() is called");
    }

    void aaa2() {
        System.out.println("aaa2() is called");
    }

    void bbb() {
        System.out.println("bbb() is called");
    }
}

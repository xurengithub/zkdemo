package com.xuren.demo.exampleproxy;

import java.lang.reflect.Type;

public class Test {
    public static void main(String[] args) {
//        StaticProxy staticProxy = new StaticProxy(new MyService());
//        staticProxy.eat("苹果");
//        System.out.println(staticProxy.say("haha"));

        Class<?>[] classes = C.class.getInterfaces();
        for (Class c : classes) {
            System.out.println(c.getName());
            System.out.println(c.getSimpleName());
        }

        Type[] types = C.class.getGenericInterfaces();
        for (Type type : types) {
            System.out.println(type.getTypeName());
        }
    }
}

package com.xuren.demo.testClass;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class JavaDemo<T extends Number, K> {
    public static void main(String[] args) {
        for (TypeVariable<Class<JavaDemo>> var : JavaDemo.class.getTypeParameters()) {
            System.out.print(var.getName() + ",");
            for (Type type : var.getBounds()) {
                System.out.print(type);
            }
            System.out.println();
        }

        System.out.println(Child.class.getSuperclass());
        System.out.println(Child.class.getGenericSuperclass());
        System.out.println(S2.class.getSuperclass());
    }

    private static class Parent<T> {
    }

    private static class S extends Parent<String>{

    }

    private static class Child extends Parent<String>{
    }

    private static class S2 implements Play {

    }
}
package com.xuren.demo.exampleannotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.xuren.demo.exampleannotation.Student");
        clazz = new Student().getClass();
        clazz = Student.class;
        CustomDescriptions customDescriptions = (CustomDescriptions) clazz.getAnnotation(CustomDescriptions.class);
//        for (CustomDescription s : customDescriptions.value()) {
//            System.out.println(s.description());
//        }
//
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f.getName());
        }

//        for (Method m : clazz.getDeclaredMethods()) {
//            System.out.println(m.getName());
//        }

        for(Constructor c : clazz.getConstructors()) {
            System.out.println(c.getName());
        }
    }
}

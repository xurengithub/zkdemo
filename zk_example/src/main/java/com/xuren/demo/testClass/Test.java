package com.xuren.demo.testClass;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test<K extends Number, T> {
    @Resource
    public K key;
    public T value;
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
//        System.out.println(Play.class.toString());
//        System.out.println(Play.class.toGenericString());
//        System.out.println(Person.class.toGenericString());
//
//        System.out.println(int.class.isInstance(2));
//        System.out.println(Integer.class.isInstance(2));
//
//        System.out.println(List[].class.isInstance(new List[2]));
//        System.out.println(List[].class.isInstance(new ArrayList[2]));
//        System.out.println(int[].class.isInstance(new Integer[2]));
//        System.out.println(Integer[].class.isInstance(new int[2]));
//
//        System.out.println(Integer[].class.getSuperclass());
//        System.out.println(Object.class.getSuperclass());
//        System.out.println("Class:" + Class.class.getSuperclass());
//        System.out.println(int.class.getSuperclass());
//        System.out.println(Object.class);
//        System.out.println(Object.class.getSuperclass());
//        System.out.println(String.class.getClass());
//
//        System.out.println(Son.class.getSuperclass());
//        System.out.println(Parent.class.getSuperclass());
//        Son.class.getAnnotations()
//        Arrays.stream(Son.class.getAnnotations()).forEach(annotation -> {
//            System.out.println(annotation);
//            System.out.println(annotation.annotationType());
//        });
//        Method method = Son.class.getMethod("add");
//        Arrays.stream(method.getDeclaredAnnotations()).forEach(new Consumer<Annotation>() {
//            @Override
//            public void accept(Annotation annotation) {
//                System.out.println(annotation);
//                System.out.println(annotation.annotationType());
//            }
//        });
//
//        Method getMethod = Son.class.getMethod("get");
//        System.out.println(getMethod.getDeclaringClass());
//        System.out.println(getMethod.getReturnType().getComponentType());
//        System.out.println(String.class.getClass());
        Field listField = Son.class.getField("list");
        System.out.println(listField.getGenericType() instanceof ParameterizedType ? ((ParameterizedType) listField.getGenericType()).getRawType() : "");
        Type type = listField.getGenericType();
        if (type instanceof ParameterizedType) {

            for (Type t1 : ((ParameterizedType) type).getActualTypeArguments()) {
                System.out.println(t1);
                if (t1 instanceof ParameterizedType) {
                    System.out.println(((ParameterizedType) t1).getRawType());
                    if (((ParameterizedType) t1).getActualTypeArguments()[0] instanceof TypeVariable) {
                        System.out.println(((ParameterizedType) t1).getActualTypeArguments()[0]);
                    }
                }
                if (t1 instanceof TypeVariable) {
                    System.out.println(t1);
                }
            }
            System.out.println(((ParameterizedType) type).getRawType());
        }


        TypeVariable[] types = Test.class.getTypeParameters();
        for (TypeVariable t : types) {
            int index = t.getBounds().length - 1;
            //输出上边界
            System.out.println("--getBounds()-- " + t.getBounds()[index]);
            //输出名称
            System.out.println("--getName()--" + t.getName());
            //输出所在的类的类型
            System.out.println("--getGenericDeclaration()--" +                                                      t.getGenericDeclaration());
        }
        Field keyField = Test.class.getField("key");
        System.out.println(keyField.getGenericType());
        System.out.println(keyField.getType());
        Field valueField = Test.class.getField("value");
        System.out.println(valueField.getGenericType());
        System.out.println(valueField.getType());
        System.out.println("---");
        System.out.println(keyField.getAnnotatedType().getType().getTypeName());;
        Arrays.stream(keyField.getDeclaredAnnotations()).forEach(new Consumer<Annotation>() {
            @Override
            public void accept(Annotation annotation) {
                System.out.println(annotation);
            }
        });
    }

}

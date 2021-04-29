package com.xuren.demo.examplesynchronized;

public class AAA {
    public static void a() {
        System.out.println(Thread.currentThread().getName()+":a");
    }

    public static void b() {
        System.out.println(Thread.currentThread().getName()+":b");
    }

    public static void c() {
        System.out.println(Thread.currentThread().getName()+":c");
    }
}

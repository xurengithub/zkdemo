package com.xuren.demo.examplesynchronized;

public class CCC {
    public void a() {
        System.out.println(Thread.currentThread().getName()+":a");
    }

    public synchronized static void b() {
        System.out.println(Thread.currentThread().getName()+":b");
    }

    public static void c() {
        System.out.println(Thread.currentThread().getName()+":c");
    }
}

package com.xuren.demo.examplesynchronized;

public class BBB {
    public synchronized static void a() {
        System.out.println(Thread.currentThread().getName()+":a");
    }

    public synchronized static void b() {
        System.out.println(Thread.currentThread().getName()+":b");
    }

    public synchronized void c() {
        System.out.println(Thread.currentThread().getName()+":c");
    }
}

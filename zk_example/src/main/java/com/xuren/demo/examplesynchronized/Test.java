package com.xuren.demo.examplesynchronized;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (test) {
                    test.a();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (test) {
                    test.b();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (test) {
                    Test.c();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    public void b() {
        System.out.println(Thread.currentThread().getName()+":b");
    }

    public void a() {
        System.out.println(Thread.currentThread().getName()+":a");
    }

    public static void c() {
        System.out.println(Thread.currentThread().getName()+":c");
    }
}

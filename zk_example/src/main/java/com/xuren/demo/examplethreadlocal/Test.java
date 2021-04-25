package com.xuren.demo.examplethreadlocal;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set(123);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                threadLocal.set(1);
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(threadLocal.get());
//            }
//        }).start();
//
//        Thread.sleep(2000);
//        System.out.println(threadLocal.get());

        Test t1 = new Test();
        t1.test();
    }

    public void test() throws InterruptedException {
        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set(123);
        System.out.println(inheritableThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(inheritableThreadLocal.get());
                inheritableThreadLocal.set(2);
                System.out.println(inheritableThreadLocal.get());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(inheritableThreadLocal.get());
            }
        }).start();
        Thread.sleep(2000);
        System.out.println(inheritableThreadLocal.get() + "xxxx");
        Thread.sleep(20000);
        System.out.println(inheritableThreadLocal.get());
    }
}

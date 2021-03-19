package com.xuren.demo;

public class Test {
    private IMyLock lock;
    public static void main(String[] args) {
        final Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行");
                test.lock.lock();
                System.out.println(Thread.currentThread().getName()+"进入临界区");
                System.out.println(Thread.currentThread().getName()+"sleep10s");
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+"sleep结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.lock.unlock();
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行");
                test.lock.lock();
                System.out.println(Thread.currentThread().getName()+"进入临界区");
                System.out.println(Thread.currentThread().getName()+"sleep10s");
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+"sleep结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.lock.unlock();
            }
        }, "t2").start();
    }
}

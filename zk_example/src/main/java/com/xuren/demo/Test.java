package com.xuren.demo;

import com.xuren.demo.examplelock.IMyLock;
import com.xuren.demo.examplelock.MyLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        final Test test = new Test();
        IMyLock lock = new MyLock();
//        Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行");
                try {
                    lock.lock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"进入临界区");
                System.out.println(Thread.currentThread().getName()+"sleep10s");
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+"sleep结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行");
                try {
                    lock.lock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"进入临界区");
                System.out.println(Thread.currentThread().getName()+"sleep10s");
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+"sleep结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}

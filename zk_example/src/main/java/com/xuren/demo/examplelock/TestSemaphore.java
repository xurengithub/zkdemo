package com.xuren.demo.examplelock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        System.out.println(semaphore.availablePermits());
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"未进入");
                        semaphore.acquire();
                        System.out.println("线程"+Thread.currentThread().getName()+"进入,当前还有"+semaphore.availablePermits()+"许可");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    semaphore.release();
                    System.out.println("线程"+Thread.currentThread().getName()+"已离开,当前还有"+semaphore.availablePermits()+"许可");

                }
            });
        }
    }
}

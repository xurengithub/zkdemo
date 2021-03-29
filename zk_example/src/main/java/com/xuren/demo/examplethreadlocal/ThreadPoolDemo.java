package com.xuren.demo.examplethreadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    public static void main(String[] args) throws InterruptedException {
        // 线程池提交的线程会被重复利用，线程持有的对象会和线程生命周期保持一致
        for (int i = 0; i < 100; ++i) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<BigObject> threadLocal = new ThreadLocal<>();
                    threadLocal.set(new BigObject());
                    // 其他业务代码
//                    threadLocal.remove();
                }
            });
            System.out.println("任务"+i);
            Thread.sleep(1000);
        }

        for (int i = 0; i < 100; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<BigObject> threadLocal = new ThreadLocal<>();
                    threadLocal.set(new BigObject());
                    // 其他业务代码
//                    threadLocal.remove();
                }
            }).start();
            System.out.println("任务"+i);
            Thread.sleep(1000);
        }
    }
    static class BigObject {
        // 100M
        private byte[] bytes = new byte[100 * 1024 * 1024];
    }
}
package com.xuren.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JstackCase {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Task t1 = new Task();
        Task t2 = new Task();
        executorService.execute(t1);
        executorService.execute(t2);
    }

    public static Object obj = new Object();
    static class Task implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                long sum = 0L;
                while (true) {
                    sum++;
                }
            }
        }
    }
}

package com.xuren.demo.examplethreadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Test {
    public static void main(String[] args) {
        Executor executor = null;


        Executors.newCachedThreadPool();
        executor = Executors.newFixedThreadPool(3);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("abc");
            }
        });
        Executors.newSingleThreadExecutor();
    }
}

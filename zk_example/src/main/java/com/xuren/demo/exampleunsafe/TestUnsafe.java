package com.xuren.demo.exampleunsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class TestUnsafe {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {

        People people = new People();
        System.out.println(people.getId());

        AtomicInteger atomicInteger = new AtomicInteger();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    int a = people.getId();
                    people.setId(a + 1);
                    atomicInteger.set(atomicInteger.get() + 1);
//                    atomicInteger.incrementAndGet();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    int a = people.getId();
                    people.setId(a + 1);
//                    atomicInteger.incrementAndGet();
                    atomicInteger.set(atomicInteger.get() + 1);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(people.getId());
        System.out.println(atomicInteger.get());
    }
}

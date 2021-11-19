package com.xuren.demo;

import org.jboss.netty.util.HashedWheelTimer;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//
//        Timer timer = new HashedWheelTimer();
//        long t1 = System.currentTimeMillis();
//        timer.newTimeout(timeout -> {
//            System.out.println(System.currentTimeMillis()-t1);
//        }, 5, TimeUnit.SECONDS);
//        timer.newTimeout(timeout -> {
//            System.out.println(System.currentTimeMillis()-t1);
//        }, 5, TimeUnit.SECONDS);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        countDownLatch.countDown();
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//                System.out.println("1111");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            countDownLatch.countDown();
//        }).start();

//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(10000);
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println(1111);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread.sleep(1000);
//        t.start();
//        System.out.println(t.isInterrupted());
////        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());
//        Thread.sleep(1000);
//        System.out.println(t.isInterrupted());
//        Thread.interrupted();



//        CountDownLatch countDownLatch = new CountDownLatch(2);
//
//
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//                System.out.println("1111");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//                System.out.println("2222");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        Thread.sleep(5000);
//        new Thread(() -> {
//            countDownLatch.countDown();
//            System.out.println("1");
//        }).start();
//        new Thread(() -> {
//            countDownLatch.countDown();
//            System.out.println("2");
//        }).start();

//        System.out.println(-1<<29);

//        Exchanger<String> exchanger = new Exchanger<>();
//        new Thread(() -> {
//            String name = Thread.currentThread().getName();
//            System.out.println("线程" + name + ":start");
//            try {
//                String newName = exchanger.exchange(name);
//                System.out.println("线程" + name + ":" + newName);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        System.out.println(111);
//        new Thread(() -> {
//            String name = Thread.currentThread().getName();
//            System.out.println("线程" + name + ":start");
//            try {
//                String newName = exchanger.exchange(name);
//                System.out.println("线程" + name + ":" + newName);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        Phaser phaser1 = new Phaser();
        Phaser phaser = new Phaser(phaser1);
        new Thread(() -> {
            phaser.register();
        }).start();

    }


    public boolean cyc(Node head) {
        Node n = head;
        Set set = new HashSet();
        set.add(n);
        while ((n = n.next) != null) {
            if(set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }

        return false;
    }

    class Node {
        public Node next;
        public Node pre;
        public int value;


    }
}

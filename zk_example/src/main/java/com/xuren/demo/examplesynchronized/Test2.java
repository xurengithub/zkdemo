package com.xuren.demo.examplesynchronized;

public class Test2 {
    public static void main(String[] args) {
        BBB bbb = new BBB();
        new Thread(new Runnable() {
            @Override
            public void run() {
                BBB.a();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                BBB.a();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}

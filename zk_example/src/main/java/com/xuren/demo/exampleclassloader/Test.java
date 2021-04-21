package com.xuren.demo.exampleclassloader;

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t.start();

    }
}

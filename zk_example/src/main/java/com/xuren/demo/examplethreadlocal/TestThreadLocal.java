package com.xuren.demo.examplethreadlocal;

public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal local = new ThreadLocal();
        local.set("Ddd");
        local.get();
        local.remove();
    }
}

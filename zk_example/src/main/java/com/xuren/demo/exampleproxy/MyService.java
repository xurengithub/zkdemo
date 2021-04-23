package com.xuren.demo.exampleproxy;

public class MyService implements IService {
    @Override
    public void eat(String s) {
        System.out.println("吃"+s);
    }

    @Override
    public String say(String s) {
        return "person say" + s;
    }
}

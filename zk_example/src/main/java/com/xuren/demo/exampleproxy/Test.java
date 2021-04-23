package com.xuren.demo.exampleproxy;

public class Test {
    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new MyService());
        staticProxy.eat("苹果");
        System.out.println(staticProxy.say("haha"));
    }
}

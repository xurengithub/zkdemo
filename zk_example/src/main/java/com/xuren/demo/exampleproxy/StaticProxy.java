package com.xuren.demo.exampleproxy;

public class StaticProxy implements IService{
    private IService service;

    public StaticProxy(IService service) {
        this.service = service;
    }

    public void eat(String s) {
        System.out.println("log start:" + s);
        service.say(s);
        System.out.println("log end:" + s);
    }

    public String say(String s) {
        return "代理：" + service.say(s);
    }
}

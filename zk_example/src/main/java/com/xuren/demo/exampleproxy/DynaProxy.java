package com.xuren.demo.exampleproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxy implements InvocationHandler {
    private Object target;
    public Object bind(Object o) {
        this.target = o;

        Object obj = Proxy.newProxyInstance(o.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
        return obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("method:" + method);
        System.out.println("args:" + args);
        System.out.println("target:" + this.target);
        System.out.println("log start");
        try {
            result = method.invoke(this.target, args);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("log end");
        return result;
    }

    public static void main(String[] args) {
        IService service = (IService) new DynaProxy().bind(new MyService());
        System.out.println(service.say("dsdsd"));
        service.eat("juzi");
    }
}

package com.xuren.demo.objpoll;

/**
 * @author xuren
 * @date 2021/11/19
 */
public final class Foo
{
    String name;
    int id;

    public Foo(String name, int id)
    {
        System.out.println("创建对象");
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

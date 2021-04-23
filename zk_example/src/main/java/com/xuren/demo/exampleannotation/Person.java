package com.xuren.demo.exampleannotation;
@CustomDescription(description = "基类")
@CustomDescription(description = "人")
public class Person {
    private String name;
    public String address = "aaaa";

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void personPrivate() {

    }
}

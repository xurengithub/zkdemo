package com.xuren.demo.design;

import java.io.LineNumberInputStream;

/**
 * 饮料抽象类
 */
public abstract class Beverage {
    private String description = "Unknown Beverage";

    private int size;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

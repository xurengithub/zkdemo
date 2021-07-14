package com.xuren.demo.design;

/**
 * 饮料抽象类
 */
public abstract class Beverage {
    private String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

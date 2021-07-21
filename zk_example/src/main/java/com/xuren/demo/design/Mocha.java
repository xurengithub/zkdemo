package com.xuren.demo.design;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ",mocha";
    }

    @Override
    public double cost() {
        if(beverage.getSize() == 1) {
            return beverage.cost() + 0.5 + 0.1;
        }
        if(beverage.getSize() == 2) {
            return beverage.cost() + 0.5 + 0.15;
        }
        if(beverage.getSize() == 3) {
            return beverage.cost() + 0.5 + 0.2;
        }
        return beverage.cost() + 0.5;
    }
}

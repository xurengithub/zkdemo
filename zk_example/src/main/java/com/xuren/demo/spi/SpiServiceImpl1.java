package com.xuren.demo.spi;

/**
 * @author xuren
 * @date 2022/1/6
 */
public class SpiServiceImpl1 implements SpiService {
    @Override
    public void say() {
        System.out.println("spi1");
    }
}

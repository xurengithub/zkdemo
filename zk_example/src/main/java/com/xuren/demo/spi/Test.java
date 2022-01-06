package com.xuren.demo.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author xuren
 * @date 2022/1/6
 */
public class Test {
    public static void main(String[] args) {
        Iterator<SpiService> spiServices = Service.providers(SpiService.class);
        while (spiServices.hasNext()) {
            SpiService spiService = spiServices.next();
            spiService.say();
        }

        ServiceLoader<SpiService> loader = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> spiServices2 = loader.iterator();
        while (spiServices2.hasNext()) {
            SpiService spiService = spiServices2.next();
            spiService.say();
        }
    }
}

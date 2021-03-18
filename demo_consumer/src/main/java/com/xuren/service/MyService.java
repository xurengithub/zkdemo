package com.xuren.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xuren.api.service.HelloDubboService;
import org.springframework.stereotype.Service;

@Service
public class MyService implements IConsumerService{
    @Reference
    private HelloDubboService helloDubboService;
    public String say(String s) {
        return helloDubboService.sayHello(s);
    }
}

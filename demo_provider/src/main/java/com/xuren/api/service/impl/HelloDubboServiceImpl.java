package com.xuren.api.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xuren.api.service.HelloDubboService;
import org.springframework.stereotype.Component;

@Service
@Component
public class HelloDubboServiceImpl implements HelloDubboService {
    public String sayHello(String name) {
        return "欢迎" + name + "使用Dubbo。";
    }
}

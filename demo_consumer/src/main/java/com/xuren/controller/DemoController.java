package com.xuren.controller;

import com.xuren.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private MyService myService;


    @GetMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return myService.say(name);
    }
}

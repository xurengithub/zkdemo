package com.xuren.demo.testClass;

import javax.annotation.Resource;
import javax.management.MXBean;
import java.util.List;
import java.util.Set;

@MXBean
@Resource
public class Son extends Parent{
    public List<Set<String>> list;
    public Class<?> c;
    @Resource
    public void add() {

    }

    public List<String> get() {
        return null;
    }
}

package com.xuren.demo.exampleset;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
//        Hashtable hashtable = new Hashtable();
//        hashtable.put("name", "xuren");
//        hashtable.get("name");
//        hashtable.remove("name");
//
//
//        HashMap<String, String> h = new HashMap<>();
//        h.put("name", "xuren");
//        h.get("name");
//        h.remove("name");


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(0, "xuren");
        concurrentHashMap.put(1, "xuren1");
        concurrentHashMap.put(2, "xuren2");
        concurrentHashMap.put(3, "xuren3");
        concurrentHashMap.put(4, "xuren4");
        concurrentHashMap.put(5, "xuren5");
        concurrentHashMap.put(6, "xuren6");
        concurrentHashMap.put(7, "xuren7");
        concurrentHashMap.put(8, "xuren8");
        concurrentHashMap.put(9, "xuren9");
        concurrentHashMap.put(10, "xuren10");
        concurrentHashMap.put(11, "xuren11");
        concurrentHashMap.put(12, "xuren12");
    }
}

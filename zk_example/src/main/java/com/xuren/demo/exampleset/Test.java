package com.xuren.demo.exampleset;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("name", "xuren");
        hashtable.get("name");
        hashtable.remove("name");


        HashMap<String, String> h = new HashMap<>();
        h.put("name", "xuren");
        h.get("name");
        h.remove("name");


    }
}

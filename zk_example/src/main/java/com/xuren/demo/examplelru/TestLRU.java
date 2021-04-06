package com.xuren.demo.examplelru;

public class TestLRU {
    public static void main(String[] args) {
        LRUCache<String> lruCache = new LRUCache<>(5);
        lruCache.set("name1", "xuren");
        lruCache.set("name2", "xuren");
        lruCache.set("name3", "xuren");
        lruCache.set("name4", "xuren");
        lruCache.set("name5", "xuren");
//        lruCache.set("name6", "xuren");
        System.out.println(lruCache.get("name1"));

        LRUCache2 cache2 = new LRUCache2(5);
        cache2.set("name1", "xuren1");
        cache2.set("name2", "xuren2");
        cache2.set("name3", "xuren3");
        cache2.set("name4", "xuren4");
        cache2.set("name5", "xuren5");
        cache2.set("name6", "xuren6");
        System.out.println(cache2.get("name1"));
    }
}

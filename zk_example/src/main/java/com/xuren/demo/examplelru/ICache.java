package com.xuren.demo.examplelru;

public interface ICache<T> {
    T get(String key);
    boolean set(String key, T value);
}

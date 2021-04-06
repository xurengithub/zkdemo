package com.xuren.demo.examplelru;

public class Node<T> {
    public Node pre;
    public Node next;

    private String key;
    private T value;

    public Node(String key, T value) {
        this.key =  key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

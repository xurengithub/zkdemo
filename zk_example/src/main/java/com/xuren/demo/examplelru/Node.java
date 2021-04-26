package com.xuren.demo.examplelru;

public class Node<T> {
    public Node pre;
    public Node next;

    private String key;
    private T value;

    public Node(String key, T value) {
        this(key, value, null, null);
    }

    public Node(String key, T value, Node pre, Node next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
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

package com.xuren.demo.examplelru;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LRUCache<T> {
    private List<Node> arr;
    private int capcity;

    public LRUCache(int capcity) {
        arr = new LinkedList<Node>();
        this.capcity = capcity;
    }
    public void set(String key,T value) {
        if(arr.size() >= capcity) {
            arr.remove(0);
        }
        if(arr.size() <= 0) {
            arr.add(new Node(key, value));
        } else {
            Iterator iterator = arr.iterator();
            while (iterator.hasNext()) {
                Node node = (Node) iterator.next();
                if(node.getKey().equals(key)) {
                    iterator.remove();
                }
            }
            arr.add(new Node(key, value));

        }
    }

    public T get(String key) {
        for (Node node : arr) {
            if(node.getKey().equals(key)) {
                return (T)node.getValue();
            }
        }
        return null;
    }

    class Node<T> {
        private String key;
        private T value;

        public Node(String key, T value) {
            this.key = key;
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
}

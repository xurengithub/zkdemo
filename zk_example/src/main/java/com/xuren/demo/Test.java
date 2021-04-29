package com.xuren.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

    }


    public boolean cyc(Node head) {
        Node n = head;
        Set set = new HashSet();
        set.add(n);
        while ((n = n.next) != null) {
            if(set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }

        return false;
    }

    class Node {
        public Node next;
        public Node pre;
        public int value;


    }
}

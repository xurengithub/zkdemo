package com.xuren.demo.examplelru;

public class LRUCache2 implements ICache<String>{
    private Node head;
    private Node tail;
    private int capcity;
    private int size;

    public LRUCache2(int capcity) {
        this.capcity = capcity;
    }

    @Override
    public String get(String key) {
        if(head == null) {
            return null;
        }

        if(head.getKey().equals(key)) {
            return (String) head.getValue();
        }

        Node t = head.next;
        while(t != null) {
            if(t.getKey().equals(key)) {
                Node p = t.pre;
                Node n = t.next;
                p.next = n;
                if(n != null) {
                    n.pre = p;
                }
                t.pre = null;
                t.next = null;
                Node tmp = head;
                head = t;
                t.next = tmp;
                tmp.pre = head;
                return (String) head.getValue();
            } else {
                t = t.next;
            }
        }
        return null;
    }

    @Override
    public boolean set(String key, String value) {
        if (head == null) {
            if(size >= capcity) {
                return false;
            }
            head = new Node(key, value);
            tail = head;
            size++;
        } else {

            // 遍历是否有相同元素
            if(head.getKey().equals(key)) {
                head = new Node(key, value);
                tail = head;
                return true;
            }
            boolean has = false;
            Node tmp = head.next;
            while (tmp != null) {
                if(tmp.getKey().equals(key)) {
                    // 删除
                    Node p = tmp.pre;
                    Node n = tmp.next;
                    tmp.pre = null;
                    tmp.next = null;
                    p.next = n;
                    n.pre = p;
                    has = true;
                    break;
                }

                tmp = tmp.next;
            }

            if(has) {
                Node node = new Node(key, value);
                Node t = head;
                node.next = head;
                t.pre = node;
                head = node;
            } else {
                // 尾巴删除
                // 头部增加
            }


        }

        return true;
    }
}

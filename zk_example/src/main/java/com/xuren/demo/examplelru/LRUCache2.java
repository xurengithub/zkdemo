package com.xuren.demo.examplelru;

import java.util.HashMap;

public class LRUCache2 implements ICache<String>{
    private Node<String> head;
    private Node<String> tail;
    private int capcity;
    private int size;
    private HashMap<String, Node<String>> map;

    public LRUCache2(int capcity) {
        this.capcity = capcity;
        map = new HashMap<String, Node<String>>(capcity);
    }

    @Override
    public String get(String key) {
        Node<String> node = map.get(key);
        if(node == null) {
            return null;
        } else {
            if(node.pre != null) {
                Node<String> pre = node.pre;
                Node<String> next = node.next;
                pre.next = next;
                if(next != null) {
                    next.pre = pre;
                }
                // 换头
                Node<String> tmp = head;
                head = node;
                node.next = tmp;
            }
            return node.getValue();
        }
    }

    @Override
    public boolean set(String key, String value) {
        if(size == 0) {
            head = new Node<String>(key, value, null, null);
            tail = head;
            size++;

            map.put(key, head);
        } else {
            if(map.containsKey(key)) {// 重复值替换value，放到队头
                Node<String> node = map.get(key);
            } else {//不重复
                if(size >= capcity) {//不可添加时，则删除尾巴，加入队头
                    Node<String> tmp = head;
                    head = new Node<String>(key, value, null, tmp);
                    map.put(key, head);
                    //倒数第二个
                    Node<String> tailPre = tail.pre;
                    if(tailPre != null) {
                        tailPre.next = null;
                        map.remove(tail.getKey());
                    }
                } else {//可添加时，则添加到队头，

                    Node<String> tmp = head;
                    head = new Node<String>(key, value, null, tmp);
                    if(tail == tmp) {
                        tail.pre = head;
                    }
                    map.put(key, head);
                    size++;
                }
            }
        }


        return false;
    }
}

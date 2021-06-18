package com.xuren.demo.consistanthash;


import java.util.*;
import java.util.function.Consumer;

public class ConsistentHash {
    private final HashFunction hashFunction;// hash 函数接口
    private final int numberOfReplicas;// 每个机器节点关联的虚拟节点个数
    private final SortedMap<Integer, Node> circle = new TreeMap<>();// 环形虚拟节点
    //真实物理节点
    private Set<Node> realNode2 = new HashSet<>();
    /**
     *
     * @param hashFunction
     *            hash 函数接口
     * @param numberOfReplicas
     *            每个机器节点关联的虚拟节点个数
     */
    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;
    }
    /**
     *
     * @param hashFunction
     *            hash 函数接口
     * @param numberOfReplicas
     *            每个机器节点关联的虚拟节点个数
     * @param nodes
     *            真实机器节点
     */
    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<Node> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for (Node node : nodes) {
            add(node);
        }
    }

    /**
     * 增加真实机器节点
     *
     * @param node
     */
    public synchronized void add(Node node) {
        if(!realNode2.contains(node)) {
            realNode2.add(node);
        }

        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.put(this.hashFunction.hash(node.getIp() + i), node);
        }
    }

    /**
     * 删除真实机器节点
     *
     * @param node
     */
    public synchronized void remove(Node node) {
        realNode2.remove(node);

        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.remove(this.hashFunction.hash(node.getIp() + i));
        }
    }

    /**
     * 取得真实机器节点
     *
     * @param key
     * @return
     */
    public synchronized Node get(String key) {
        if (circle.isEmpty()) {
            return null;
        }

        Integer hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, Node> tailMap = circle.tailMap(hash);// 沿环的顺时针找到一个虚拟节点
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        return circle.get(hash);
    }

    public Integer hash(String key) {
        return hashFunction.hash(key);
    }

    /**
     * 新集合重新创建服务节点
     * @param newSet
     */
    public synchronized void refreshServerNode(Set<Node> newSet) {
        Set<Node> sameNodes = new HashSet<>();
        Set<Node> deleteNodes = new HashSet<>();
        Set<Node> addNodes = new HashSet<>();
        realNode2.stream().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                if(newSet.contains(node)) {
                    sameNodes.add(node);
                }
            }
        });
        realNode2.stream().forEach(node -> {
            if(!sameNodes.contains(node)) {
                deleteNodes.add(node);
            }
        });
        newSet.stream().forEach(node -> {
            if(!sameNodes.contains(node)) {
                addNodes.add(node);
            }
        });

        addNodes.stream().forEach(node -> {
            add(node);
        });

        deleteNodes.stream().forEach(node -> {
            remove(node);
        });
    }
}

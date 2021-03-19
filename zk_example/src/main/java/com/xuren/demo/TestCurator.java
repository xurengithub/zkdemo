package com.xuren.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.function.Consumer;

public class TestCurator {
    public static void main(String[] args) {
        String connectStr = "49.232.215.156:2182";
        int connectTimeOut = 2000;
        int sessionTimeOut = 2000;
        String nodePath = "/node";
        String subSeqNodePath = "/node/n_";
        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectStr).connectionTimeoutMs(connectTimeOut)
                .sessionTimeoutMs(sessionTimeOut)
                .retryPolicy(exponentialBackoffRetry)
                .build();
        client.start();
        try {
            client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(subSeqNodePath, "ttt".getBytes());
            client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(subSeqNodePath, "ttt".getBytes());
            List<String> list = client.getChildren().forPath(nodePath);
            list.stream().forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(s);
                }
            });

//            client.setData().withVersion(3).forPath(nodePath, "sssaaa".getBytes());
//            client.delete().inBackground(statCallback).forPath(nodePath);
            client.setData().inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                    System.out.println("event[code: " + curatorEvent.getResultCode() + ", type: " + curatorEvent.getType() + "]");
                    System.out.println("Thread of processResult: " + Thread.currentThread().getName());

                }
            }).forPath(nodePath, "abcdefghk".getBytes());
            client.getData().usingWatcher(new CuratorWatcher() {
                @Override
                public void process(WatchedEvent watchedEvent) throws Exception {
                    if(watchedEvent.getType() == Watcher.Event.EventType.NodeDataChanged) {
                        System.out.println(watchedEvent.getPath());
                        System.out.println(watchedEvent.getState().getIntValue());
                        System.out.println(watchedEvent.getWrapper());
                    }
                }
            }).forPath(nodePath);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}

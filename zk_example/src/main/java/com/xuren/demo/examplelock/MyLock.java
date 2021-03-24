package com.xuren.demo.examplelock;

import com.xuren.demo.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

public class MyLock implements IMyLock{

    private CuratorFramework client;
    private String path = "/path_lock";
    private String elockNode = "/e_clock";
    private String fullPath;
    public MyLock() {
        client = ClientFactory.createSimple("49.232.215.156:2182");
        client.start();
        fullPath = path + elockNode + "_" + System.currentTimeMillis();
    }

    @Override
    public boolean lock(){
            // 创建节点
            // 创建成功则通过
            // 创建不成功则获取节点列表watch等待通知
            try {
                while (!tryLock()) {
                    await();

                }
            } catch (Exception e) {
                unlock();
                e.printStackTrace();
            }
            return true;

    }


    @Override
    public boolean unlock() {
        // 当前线程删除节点
        try {
            client.delete().forPath(fullPath);
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName()+"节点删除失败");
//            e.printStackTrace();
            return false;
        }
        System.out.println(Thread.currentThread().getName()+"节点删除成功");
        return true;
    }

    private boolean tryLock(){
        String nodePath = null;
        try {
            nodePath = client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(fullPath);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"节点创建失败");
            return false;
        }
        if(nodePath != null && !"".equals(nodePath)) {
            System.out.println(Thread.currentThread().getName()+"节点创建成功");
            return true;
        }
        return false;
    }

    private void await() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        client.getData().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent watchedEvent) throws Exception {
                if(watchedEvent.getType() == Watcher.Event.EventType.NodeDeleted) {
                    System.out.println(Thread.currentThread().getName()+"接受节点删除通知");
                    countDownLatch.countDown();
                }
            }
        }).forPath(fullPath);

        countDownLatch.await();
    }
}

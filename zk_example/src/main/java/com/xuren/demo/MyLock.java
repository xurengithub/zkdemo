package com.xuren.demo;

public class MyLock implements IMyLock{
    /**
     * 当前线程
     */
    private volatile Thread currentThread;
    @Override
    public void lock() {
        // 创建节点
        // 创建成功则通过
        // 创建不成功则获取节点列表watch等待通知


    }


    @Override
    public void unlock() {
        // 当前线程删除节点

    }
}

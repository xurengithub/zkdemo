package com.xuren.demo.examplelock;

public interface IMyLock {
    /**
     * 加锁。获取到锁的线程继续执行，未获取到锁得等待阻塞
     */
    boolean lock();

    /**
     * 释放锁，通知其他等待阻塞的线程停止等待阻塞，并开始的竞争锁
     */
    boolean unlock();
}

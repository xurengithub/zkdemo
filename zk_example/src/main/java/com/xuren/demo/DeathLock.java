package com.xuren.demo;

import java.util.concurrent.TimeUnit;

class DeathLock implements Runnable{
    private  String ziyuanA;
    private  String ziyuanB;

    public DeathLock(String lockA, String lockB) {
        this.ziyuanA = lockA;
        this.ziyuanB = lockB;
    }


    @Override
    public void run() {
        synchronized (ziyuanA){
            System.out.println(Thread.currentThread().getName()+"持有"+ ziyuanA +"尝试获得"+ziyuanB);
            //暂停线程//给另外一个线程时间去锁定另一个资源//若不锁定可能
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            //若这里获得不到ziyuanB将会进入等待
            synchronized (ziyuanB){
                System.out.println(Thread.currentThread().getName()+"持有"+ziyuanB+"尝试获得"+ ziyuanA);
            }

        }
    }
}

class DeathThread {
    public static void main(String[] args){
        String lockA="zylockAA";
        String lockB="zylockBB";
        new Thread(new DeathLock(lockA, lockB),"线程a").start();
        new Thread(new DeathLock(lockB, lockA),"线程b").start();
    }
}
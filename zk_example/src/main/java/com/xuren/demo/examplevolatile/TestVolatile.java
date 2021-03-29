package com.xuren.demo.examplevolatile;

public class TestVolatile {
    public static void main(String[] args) {
        Ao ao = new Ao();
        ao.start();
        for (; ; ) {
            if(ao.getFlag()) {
                // 永远都输出不了
                System.out.println("haha");
            }
        }
    }
}

class Ao extends Thread {
    private boolean flag = false;
    public boolean getFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("falg="+flag);

    }
}

package com.xuren.demo.suanfa;

public class IntOutOfBounds {
    public static void main(String[] args) {
        int  a = Integer.MAX_VALUE;
        a++;
        System.out.println(a);

        long b = (long)a;
        System.out.println((int) ((long)a));
        if(a != (int) ((long)a)){
            System.out.println("溢出");
        }
    }
}

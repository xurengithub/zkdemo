package com.xuren.demo.face;

import java.math.BigDecimal;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] a1 = new int[]{3,7,20,18,17,15,21,22,5,9,8};
        int[] a2 = new int[]{3,6,20,18,17,15,21,22,5,9,8};

        int[] a3 = retainAll2(a1, a2);
        for (int i : a3) {
            System.out.println(i);
        }

        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                synchronized (a) {

                }
            }
        }).start();
    }

    /**
     * 假设无序
     * @param array1
     * @param array2
     * @return
     */
    public static int[] retainAll(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        int[] newArray = new int[len1 < len2 ? len1 : len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(array1[i] == array2[j]) {
                    newArray[i] = array1[i];
                }
            }
        }

        return newArray;
    }

    /**
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] retainAll2(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        int[] newArray = new int[len1 < len2 ? len1 : len2];
        int i = 0;
        int j = 0;
        while (i <= len1-1 && j <= len2-1) {
            int a1 = array1[i];
            int a2 = array2[j];
            if(a1 == a2) {
                newArray[i] = a1;
                i++;
                j++;
            } else if(a1 > a2) {
                j++;
            } else {
                i++;
            }
        }

        return newArray;
    }

    private BigDecimal getPrice(BigDecimal p1, BigDecimal p2){
        if(p1.compareTo(p2) == 0)return p1;
        if(p1.compareTo(p2) > 0){
            return p2.add((p1.subtract(p2).multiply( new BigDecimal(new Random().nextDouble()))));
        }else{
            return p1.add((p2.subtract(p1).multiply( new BigDecimal(new Random().nextDouble()))));
        }
    }

}

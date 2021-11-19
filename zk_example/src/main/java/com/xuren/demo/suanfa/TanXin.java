package com.xuren.demo.suanfa;

public class TanXin {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = (right-left)*Math.min(height[left], height[right]);
        while(right>left){
            if(height[left] < height[right]) {
                if(height[left++] < height[left]) {
                    int newMax = (right-left)*Math.min(height[left], height[right]);
                    if(max < newMax) {
                        max = newMax;
                    }
                }
            } else {
                if(height[right--] < height[right]) {
                    int newMax = (right-left)*Math.min(height[left], height[right]);
                    if(max < newMax) {
                        max = newMax;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TanXin tanXin = new TanXin();
        System.out.println(tanXin.maxArea(new int[]{1,1,12,4,2,1,44,40,2,6,9}));
    }
}

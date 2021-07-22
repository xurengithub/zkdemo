package com.xuren.demo.suanfa;

public class TanXin {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = (right-left)*Math.min(height[left], height[right]);
        int lastLeft = height[0];
        int lastRight = height[height.length-1];
        while(right>left){
            if(height[left] < height[right]) {
                left++;
                if(lastLeft < height[left]) {
                    int newMax = (right-left)*Math.min(height[left], height[right]);
                    if(max < newMax) {
                        max = newMax;
                    }
                }
            } else {
                right--;
                if(lastRight < height[right]) {
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
        System.out.println(tanXin.maxArea(new int[]{1,1}));
    }
}

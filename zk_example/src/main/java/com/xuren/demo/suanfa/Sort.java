package com.xuren.demo.suanfa;

public class Sort {
    /**
     * 取一个基准值
     * 两个哨兵指针
     * @param arr
     * @return
     */
    public int[] quickSort(int[] arr) {
        quickSort2(arr, 0, arr.length-1);
        return arr;
    }

    public void quickSort2(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int jizhun = arr[start];

        int k = 0;
        while (i!=j) {
            while (arr[j] >= jizhun && j>i) {
                j--;
            }
            while (arr[i] <= jizhun && i<j) {
                i++;
            }

            if(i != j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                //交换完然后继续循环
            } else {// 交换基准值
                if(i!=0) {
                    int tmp = arr[start];
                    arr[start] = arr[i];
                    arr[i] = tmp;
                    // 左边进行quicksort
                    quickSort2(arr, start, i-1);
                    quickSort2(arr, i+1, end);
                    break;
                }
            }
        }
    }

    /**
     * 选择未排序的最小的元素和第一个未排序元素交换
     * @param arr
     * @return
     */
    public int[] selectSort(int[] arr) {
        if(arr.length <= 0) {
            return null;
        }
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return arr;
    }

    /**
     * 已排序，未排序，未排序第一个拿出来插入已排序中
     * @param arr
     * @return
     */
    public int[] insertSort(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        int a = 0;
        for(int i = 1; i < len; i++) {
            a = arr[i]; //取出一个未排序第一个
            for (int j = i - 1; j >= 0; j--) {
                // 1.先移动 后插入
                if(a < arr[j]) {
                    arr[j+1] = arr[j];
                    if(j < 0) {
                        arr[j] = a;
                    }
                } else {
                    arr[j+1] = a;
                    break;
                }
                if(j == 0) {
                    arr[j] = a;
                }
                // 2.直接交换
//                if(arr[j] > arr[j+1]) {
//                    int tmp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = tmp;
//                } else {
//                    break;
//                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,11,4,6,20,18,19,7,8};
        arr = new int[]{2,2,5,3,1,11,4,6,20,18,19,7,8};
        Sort sort = new Sort();
        int[] sortedArr;
//      sortedArr = sort.selectSort(arr);
//        sortedArr = sort.insertSort(arr);
        sortedArr = sort.quickSort(arr);
        for (int a: sortedArr) {
            System.out.println(a);
        }
    }
}

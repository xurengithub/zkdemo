package com.xuren.demo.face;

public class BuyTest {
    public static void main(String[] args) {
        BuyTest test = new BuyTest();
//        System.out.println(test.buyOrange(19));
        System.out.println(test.buyToy(1,12));
    }

    public int buyOrange(int n) {
        int[] arr = new int[n+1];

        if(n < 8) {
            for (int i = 0 ; i < n; i++) {
                if(i == 3) {
                    arr[i] = 1;
                } else if(i == 5) {
                    arr[i] = 1;
                } else if(i == 6) {
                    arr[i] = 2;
                } else {
                    arr[i] = -1;
                }

                return arr[n];
            }
        }

        if(n > 8) {
            for (int i = 0 ; i < 8; i++) {
                if(i == 3) {
                    arr[i] = 1;
                } else if(i == 5) {
                    arr[i] = 1;
                } else if(i == 6) {
                    arr[i] = 2;
                } else {
                    arr[i] = -1;
                }
            }
        }
        for (int i = 8; i <= n; i ++) {
            int a = arr[i-3];
            int b = arr[i-5];
            if(a == -1 && b == -1) {
                arr[i] = -1;
            }
            if(a == -1 && b != -1) {
                arr[i] = b + 1;
            }
            if(a != -1 && b == -1) {
                arr[i] = a + 1;
            }
            if(a != -1 && b != -1) {
                arr[i] = a > b ? b + 1 : a + 1;
            }
        }
        return arr[n];
    }

    public int buyToy(int n, int m) {
        if(n < 1) {
            return 0;
        }

        if(n*50 < m) {
            return 0;
        }
        int[][] arr = new int[n+1][m+1];

        if(m < 1) {
            for (int i = 0; i < n; i ++) {
//                arr[i][0] = //这个公式没总结出来 0,4,10....

            }
        } else {
            arr[1][0] = 4;// 1张且只要1块钱就能买 1、5、10、50
            arr[1][1] = 4;
        }

        if(m>=2 && m <=5) {
            for (int i = 2; i <= m; i++) {
                arr[1][i] = 3;
            }
        }
        if(m>=6 && m <= 10) {
            for (int i = 6; i <= m; i++) {
                arr[1][i] = 2;
            }
        }
        if(m >= 11 && m <= 50) {
            for (int i = 11; i <= m; i++) {
                arr[1][i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= m; j++) {

                    if(m >= 1 && j >= 1) {
                        arr[i][j] = arr[i-1][j-1] + 4;
                    }
                    if(m >=5 && j >= 5) {
                        arr[i][j] = arr[i-1][j-1] + 4 + arr[i-1][j-5];
                    }

                    if(m >= 10 && j >= 10) {
                        arr[i][j] = arr[i-1][j-1] + 4 + arr[i-1][j-5] + arr[i-1][j-10];
                    }

                    if(m >= 50 && j >= 50) {
                        arr[i][j] = arr[i-1][j-1] + 4 + arr[i-1][j-5] + arr[i-1][j-10] + arr[i-1][j-50];
                    }

                }
            }


        return arr[n][m];
    }
}

package com.leo.interview.dp;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://blog.csdn.net/baidu_28312631/article/details/47418773
 * @Date: Created in 9:59 2018/5/3
 **/
public class TrianglePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nRow = scanner.nextInt();
        int[][] arr = new int[nRow+1][nRow+1];
        for (int i = 1 ; i <= nRow ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(recursion(arr, nRow, 1, 1));

        int[][] maxSum = new int[nRow+1][nRow+1];
        System.out.println(recursionOptimize(arr,maxSum,nRow,1,1));

        System.out.println(dp(arr,nRow,1,1));
    }

    private static int recursion(int[][] arr,int nRow, int x, int y) {
        if (x == nRow) {
            return arr[x][y];
        }
        return Math.max(recursion(arr, nRow, x+1, y),recursion(arr, nRow, x+1, y+1)) + arr[x][y];
    }

    private static int recursionOptimize(int[][] arr, int[][] maxSum, int nRow, int x, int y) {
        if (maxSum[x][y] != 0) {
            return maxSum[x][y];
        }
        if (x == nRow) {
            maxSum[x][y] = arr[x][y];
        }else {
            maxSum[x][y] = Math.max(recursionOptimize(arr,maxSum,nRow,x+1,y), recursionOptimize(arr,maxSum,nRow,x+1,y+1))+arr[x][y];
        }
        return maxSum[x][y];
    }

    private static int dp(int[][] arr,int nRow,int x,int y){
        int[][] dp = new int[nRow+1][nRow+1];
        for (int i = 1; i <= nRow ;i++) {
            dp[nRow][i] = arr[nRow][i];
        }
        for (int i = nRow - 1; i >= 1;i--) {
            for (int j = 1 ; j <= i ; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[x][y];
    }
}

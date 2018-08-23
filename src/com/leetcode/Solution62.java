package com.leetcode;

/**
 * Created by leo on 2018/8/5.
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        // 初始化dp[*][0] dp[0][*]
        for (int i = 0 ; i < n ; i++) {
            arr[0][i] = 1;
        }
        for (int i = 0 ; i < m ; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1 ; i < m ; i++) {
            for (int j = 1 ; j < n ; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        return arr[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(7,3));
    }
}

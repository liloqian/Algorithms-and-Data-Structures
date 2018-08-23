package com.leetcode;

/**
 * Created by leo on 2018/8/5.
 */
public class Solution65 {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }else if (i == 0 ) {
                    dp[i][j] = dp[0][j-1] + grid[i][j];
                }else if (j == 0) {
                    dp[i][j] = dp[i-1][0] + grid[i][j];
                }else {
                    if (dp[i-1][j] > dp[i][j-1]) {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }else {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {

    }
}

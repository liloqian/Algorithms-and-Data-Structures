package com.leetcode;

/**
 * Created by leo on 2018/8/7.
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ret = new int[obstacleGrid.length][obstacleGrid[0].length];
        ret[0][0] = 1;
        for (int i = 1 ; i < obstacleGrid.length ; i++) {
            if (obstacleGrid[i][0] == 1) {
                ret[i][0] = 0;
            }else {
                ret[i][0] = ret[i-1][0];
            }
        }
        for (int i = 1 ; i < obstacleGrid[0].length ; i++) {
            if (obstacleGrid[0][i] == 1) {
                ret[0][i] = 0;
            }else {
                ret[0][i] = ret[0][i-1];
            }
        }

        for (int i = 1 ; i < obstacleGrid.length ; i++) {
            for (int j = 1 ; j < obstacleGrid[0].length ;j++) {
                if (obstacleGrid[i][j] == 1) {
                    ret[i][j] = 0;
                }else {
                    ret[i][j] = ret[i-1][j] + ret[i][j-1];
                }
            }
        }

        return ret[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];

    }
}

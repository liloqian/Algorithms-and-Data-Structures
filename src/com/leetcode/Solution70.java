package com.leetcode;

/**
 * Created by leo on 2018/8/7.
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2 ; i < n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];

    }

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(3));
    }

    public int climbStairsBG(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairsBG(n-1) + climbStairsBG(n-2);
    }
}

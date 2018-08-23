package com.leetcode;

/**
 * Created by leo on 2018/8/9.
 */
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
        {
            return 1;
        }
        int result = 10;
        int count = 9;
        for (int i = 1; i < n;i++)
        {
            result += count*(10 - i);
            count *= (10 - i);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution357().countNumbersWithUniqueDigits(3));
    }
}

package com.leo.leetCode;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description: Given an array of integers, every element appears three times except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @Date: Created in 10:23 2018/4/10
 **/
public class SingleNumberII {
    public int singleNumber(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        for (int i = 1 ; i < A.length ;i++) {
            if (A[i] == A[i-1]) {
                i = i+2;
            }else {
                return A[i-1];
            }
        }
        return A[A.length-1];
    }
}

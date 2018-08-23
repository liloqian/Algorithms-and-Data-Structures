package com.leetcode;

import java.util.Arrays;

/**
 * Created by leo on 2018/7/28.
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        for (int i = 0 ; i < nums1.length ; i++) {
            all[i] = nums1[i];
        }
        for (int i = 0 ; i < nums2.length ; i++) {
            all[i + nums1.length] = nums2[i];
        }
        Arrays.sort(all);
        if (all.length == 1) {
            return all[0];
        }
        int mid = all.length / 2 ;
        if (all.length % 2 == 0) {
            return (all[mid] + all[mid - 1]) / 2.0;
        }else {
            return all[mid];
        }
    }

    static int test;
    public static void main(String[] args) {
        System.out.println(test);
    }
}

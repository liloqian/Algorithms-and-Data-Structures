package com.leetcode;

import java.util.Map;

/**
 * Created by leo on 2018/8/5.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
        }
        if (max < 0) {
            return max;
        }
        int retMax = nums[0];
        int currentMax = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            if (currentMax > 0) {
                if (currentMax + nums[i] > 0) {
                    currentMax += nums[i];
                }else {
                    currentMax = 0;
                }
            }else {
                currentMax = nums[i];
            }
            retMax = Math.max(retMax, currentMax);
        }
        return retMax;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,3,1,3};
        System.out.println(new Solution53().maxSubArray(arr));
    }
}

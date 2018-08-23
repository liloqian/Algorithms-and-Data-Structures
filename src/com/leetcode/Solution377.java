package com.leetcode;

import java.util.Arrays;

/**
 * Created by leo on 2018/8/11.
 */
public class Solution377 {
    public int combinationSum4Bg(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1 ;i <= target ; i++) {
            for (int j = 0 ; j < nums.length ; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i-nums[j]];
                }else {
                    break;
                }
            }
        }
        return dp[target];
    }
    public int combinationSum4(int[] nums, int target) {
        int ret = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (target >= nums[i]) {
                ret += dealCore(target-nums[i],nums);
            }
        }
        return ret;
    }

    private int dealCore(int target, int[] nums) {
        if (target == 0) {
            return 1;
        }else if (target < 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] <= target) {
                ret += dealCore(target-nums[i],nums);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3};
        int target = 4;
        System.out.println(new Solution377().combinationSum4Bg(arr,target));
    }
}

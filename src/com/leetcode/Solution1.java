package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by leo on 2018/7/27.
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if (hashMap.keySet().contains(nums[i])) {
                int[] arr =  new int[]{i, hashMap.get(nums[i])};
                Arrays.sort(arr);
                return arr;
            }
            hashMap.put(target - nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] ret= new Solution1().twoSum(arr, 9);
        for (int i : ret) {
            System.out.print(i+" ");
        }
    }
}

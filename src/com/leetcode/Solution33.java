package com.leetcode;

/**
 * Created by leo on 2018/8/11.
 * https://www.nowcoder.com/cts/11474493/summary?id=31182CC278F2F950
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[mid+1]) {
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if (nums[left] < target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(new Solution33().search(arr,1));
    }
}

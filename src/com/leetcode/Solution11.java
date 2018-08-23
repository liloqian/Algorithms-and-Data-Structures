package com.leetcode;

/**
 * Created by leo on 2018/7/29.
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea,(right - left) * Math.min(height[left],height[right]));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea(arr));
    }
}

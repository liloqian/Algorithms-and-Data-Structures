package com.leo.sword.problem.problem28;

/**
 * @Author: qian
 * @Description: 数组连续子数组的最大和
 * @Date: Created in 9:35 2018/3/23
 **/
public class SubArrSum {
    /**
     * 类似动态规划的思想
     * */
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxRet = array[0];
        int dp = array[0];
        for (int i = 1 ; i < array.length ;i++) {
            dp = Math.max(dp+array[i], array[i]);
            maxRet = Math.max(maxRet, dp);
        }
        return maxRet;
    }
}

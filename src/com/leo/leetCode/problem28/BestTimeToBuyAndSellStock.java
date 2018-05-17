package com.leo.leetCode.problem28;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:49 2018/5/9
 **/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) {
            release2 = Math.max(release2, hold2+i);
            hold2 = Math.max(hold2, release1 - i);
            release1 = Math.max(release1, hold1 + i);
            hold1 = Math.max(hold1, -i);
        }
        return release2;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(arr));
    }
}

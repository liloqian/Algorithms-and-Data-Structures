package com.leo.leetCode.problem29;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:28 2018/5/9
 **/
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1 ; i < prices.length ; i++) {
            int temp = prices[i] - prices[i-1];
            if (temp > 0) {
                maxProfit += temp;
            }
        }
        return maxProfit;
    }
}

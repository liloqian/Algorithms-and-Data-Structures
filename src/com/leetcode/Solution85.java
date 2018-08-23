package com.leetcode;

import java.util.Stack;

/**
 * Created by leo on 2018/8/10.
 */
public class Solution85 {
    //[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    public static void main(String[] args) {
        char[][] arr = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new Solution85().maximalRectangle(arr));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 1;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }else if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }

        int retMax = -1;
        for (int i = 0 ; i < matrix.length ; i++) {
            int currentRowMax = largestRectangleArea(dp[i]);
            retMax = Math.max(retMax, currentRowMax);
        }

        return retMax;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        //压入第一个柱状图的下标
        stack.push(0);
        int i = 1;
        int max = heights[0];
        //当i < heights.length 或者栈不为空时，这里之所以需要判断栈不为空，是因为
        //可能有些高度很小的柱状图，一直停留在栈中，没有机会pop出来计算面积，所以最后需要一一的pop出来
        //计算面积
        while (i < heights.length || (i == heights.length && !stack.isEmpty())) {
            //当当前的高度大于大于栈顶的高度或者栈为空时，将当前的下标压栈
            if (i < heights.length && (stack.isEmpty() || heights[stack.peek()] <= heights[i])) {
                stack.push(i);
                i++;
            } else { //计算面积
                int top = heights[stack.pop()]; //得到栈顶的高度
                //计算面积，当当前的栈为空时，直接是top * i（i里面已经包含了中间被pop出去的柱状图）；不为空时，
                //则使用相对位置计算
                int currMax = !stack.isEmpty() ? (i - stack.peek() - 1) * top : top * i;
                //更新最大值
                max = Math.max(max, currMax);
            }
        }
        return max;
    }
}

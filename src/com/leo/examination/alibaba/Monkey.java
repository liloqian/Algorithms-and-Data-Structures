package com.leo.examination.alibaba;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:53 2018/3/30
 **/
public class Monkey {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        //记录每个位置最长递增子序列的长度
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;//从1开始
            for (int j = 0; j < i; j++) {
                //如果是i位置大于j位置，并且j位置的最长递增子序列的长度+1长于目前i位置的最长递增子序列的长度，则更新i位置的最长递增子序列
                if (nums[j] <= nums[i] &&
                        result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i : result)
            max = i > max ? i : max;
        System.out.println(max);
    }
}

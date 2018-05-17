package com.leo.leetCode.problem23;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:03 2018/5/4
 **/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num.length == 0 || num.length == 1) {
            return num.length;
        }

        Arrays.sort(num);

        int maxConsecutive = 1;
        for(int i = 1 ; i < num.length ; i++) {
            if (num[i] == num[i-1] + 1) {
                int temp = 2;
                i++;
                while (i < num.length ) {
                    if (num[i] == num[i-1] + 1) {
                        i++;
                        temp++;
                    }else if (num[i] == num[i-1]) {
                        i++;
                    }else {
                        break;
                    }
                }
                if (maxConsecutive < temp) {
                    maxConsecutive = temp;
                }
            }
        }
        return maxConsecutive;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,1};
        System.out.print(new LongestConsecutiveSequence().longestConsecutive(arr));
    }
}

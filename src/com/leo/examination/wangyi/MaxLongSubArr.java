package com.leo.examination.wangyi;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/question/next?pid=6291726&qid=112724&tid=14640915
 * @Date: Created in 22:33 2018/3/28
 **/
public class MaxLongSubArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int ret = core(str);

        System.out.println(ret);
    }

    private static int core(String str) {
        char[] arr = str.toCharArray();

        int maxRet = 1;
        for (int i = 1 ; i < arr.length ; i++) {
            int current = 1;
            while (i < arr.length && arr[i] != arr[i-1]) {
                current++;
                i++;
            }
            if (maxRet < current) {
                maxRet = current;
            }
        }

        return maxRet;
    }
}

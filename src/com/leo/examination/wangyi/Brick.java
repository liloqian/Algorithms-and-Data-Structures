package com.leo.examination.wangyi;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description:https://www.nowcoder.com/test/question/8c29f4d1bea84d6ba2847e079b7420f7?pid=6291726&tid=14640915
 * @Date: Created in 22:21 2018/3/28
 **/
public class Brick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] chars = str.toCharArray();

        int ret = core(chars);

        System.out.println(ret);
    }

    private static int core(char[] chars) {
        int[] hashArr = new int[128];
        for (char c : chars) {
            hashArr[c]++;
        }
        int temp = 0;
        for (int i : hashArr) {
            if (i > 0) {
                temp++;
            }
        }
        if (temp == 2) {
            return 2;
        } else if (temp == 1){
            return 1;
        }else {
            return 0;
        }
    }
}

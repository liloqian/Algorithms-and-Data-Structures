package com.leo.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description: 判断一个数字是否是2的n次方
 * @Date: Created in 9:22 2018/4/16
 **/
public class JudgeNumberIsMultipleOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aim = scanner.nextInt();
        if (aim == 0) {
            System.out.println("0 是2的n次方");
        }
        int temp = 2;
        while (temp < aim) {
            temp *= 2;
        }
        if (temp == aim) {
            System.out.println(aim + " 是2的n次方");
        }else {
            System.out.println(aim + " 不是2的n次方");
        }
    }
}

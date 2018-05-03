package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:56 2018/4/25
 **/
public class OneCountOfInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int retCount = 0;
        while (num != 0) {
            retCount++;
            num = (num - 1) & num;
        }
        System.out.println(retCount);
    }
}

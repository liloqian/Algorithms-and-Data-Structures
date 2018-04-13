package com.leo.examination.tencent;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:08 2018/4/5
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int allNumber = scanner.nextInt();
        if (days <= 1) {
            System.out.println(allNumber);
            return;
        }

        int bigMax = allNumber / 2 + 1;
        while (bigMax >= 0) {
            int tempSum = 0;
            int temp = bigMax;
//            System.out.println(bigMax + "  --");
            for (int i = 0 ; i < days ;i++) {
                tempSum += temp;
                if (temp % 2 == 0) {
                    temp /= 2;
                }else {
                    temp /= 2;
                    temp = temp + 1;
                }
            }
            if (tempSum <= allNumber) {
                break;
            }else {
                bigMax--;
            }
        }
        System.out.println(bigMax);
    }
}

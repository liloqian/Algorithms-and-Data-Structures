package com.leo.examination.meiTuan;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: 同main
 * @Date: Created in 18:53 2018/4/20
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrLen = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        // 构建数组
        int[] arr = new int[arrLen];
        arr[0] = p;
        for (int i = 1 ; i < arr.length ;i++) {
            arr[i] = (arr[i-1] + 153) % p;
        }

        // 计算
        int sum = 0;
        for (int i = 1 ; i <= n; i++) {
            for (int j = 1 ; j <= m ;j++) {
                int index = gcd(i,j);
                sum += arr[index-1];
            }
        }

        System.out.println(sum);
    }

    /**
     * 最大公约数
     * */
    private static int gcd(int a,int b) {
        if (b == 0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }
}

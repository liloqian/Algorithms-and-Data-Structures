package com.leo.examination.alibaba;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:53 2018/3/30
 **/
import java.util.Scanner;

public class Tree {

    public static void main(String[] args) {
        int res = resolve();
        System.out.println(res);
    }

    static int resolve() {
        Scanner in = new Scanner(System.in);
        int num  = 0;
        int[] arr = new int[16];    // 用数组存储树，丛1开始，4层最多15个节点

        // 初始化树
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        // 获取输入
        do {
            num = Integer.parseInt(in.nextLine().trim());
            if (num == 0) break;

            int a = num / 100;
            int b = num / 10 % 10;
            int c = num % 10;

            int pos = (int)(Math.pow(2, a - 1)) + b - 1;
            arr[pos] = c;

        } while (true);

        // 找到叶节点，对路径求和
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            boolean isleaf = false;
            if ((i >= 8 && arr[i] != -1) || (i < 8 && arr[i] != -1 && arr[2 * i] == -1 && arr[2 * i + 1] == -1)) {
                isleaf = true;
            }
            int k = i;
            if (isleaf) {
                while (k >= 1) {
                    sum += arr[k];
                    k /= 2;
                }
            }
        }


        return sum;
    }
}
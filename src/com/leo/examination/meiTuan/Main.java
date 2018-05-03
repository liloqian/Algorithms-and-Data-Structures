package com.leo.examination.meiTuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description： GCD，计算最大公约数
 * @Date: Created in 18:53 2018/4/20
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrLen = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        // 计算
        List<Integer> list = new ArrayList<>();
        int temp = Math.min(n,m);
        for (int i = 1 ; i <= temp; i++) {
            for (int j = i ; j <= temp ;j++) {
                int index = gcd(i,j);
                if (i == j) {
                    list.add(index);
                }else {
                    list.add(index);
                    list.add(index);
                }
            }
        }
        if (n != m) {
            int max = Math.max(n,m);
            for (int i = 1 ; i <= temp ; i++) {
                for (int j = temp+1 ; j <= max; j++) {
                    list.add(gcd(i,j));
                }
            }
        }
        Collections.sort(list);
        // 数组填充，避免创建大数组
        int[] arr = new int[list.get(list.size()-1)];
        arr[0] = p;
        for (int i = 1 ; i < arr.length ;i++) {
            arr[i] = (arr[i-1] + 153) % p;
        }

        //计算结果
        int sum = 0;
        for (int i : list) {
            sum += arr[i-1];
        }

        System.out.println(sum);
    }

    /**
     * 最大公约数
     * */
    private static int gcd(int a,int b) {
        int temp ;
        while (b > 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

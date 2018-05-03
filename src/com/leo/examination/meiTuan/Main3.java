package com.leo.examination.meiTuan;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description  给定一个数字，返回一个数字（14 12345678910111213有17位，返回17）
 * @Date: Created in 18:53 2018/4/20
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0 ; i < count ;i++) {
            int num = scanner.nextInt();
            // core
            int nLen = 0;
            int temp = num;
            while (temp != 0) {
                nLen++;
                temp /= 10;
            }
            int[] arr = new int[nLen];
            arr[0] = 9;
            System.out.print(arr[0]+" ");
            for (int j = 1 ; j < arr.length ;j++) {
                int current = (int) (Math.pow(10, j+1)  - Math.pow(10, j));
                arr[j] = (j+1)*current + arr[j-1];
                System.out.print(arr[j]+" ");
            }
            System.out.println();

            int diff = (int) Math.pow(10, nLen) - 1 - num ;
            int diffPow = diff * nLen;
            System.out.println(arr[arr.length-1] -  diffPow);
        }
    }

//    List<Integer> list = new ArrayList<>();
//        for (int i = 1 ; i <= n; i++) {
//        for (int j = 1 ; j <= m ;j++) {
//            int index = gcd(i,j);
//            list.add(index);
//        }
//    }
}


//import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * @Author: qian
// * @Description
// * @Date: Created in 18:53 2018/4/20
// **/
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int arrLen = scanner.nextInt();
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int p = scanner.nextInt();
//
//        // 计算
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1 ; i <= n; i++) {
//            for (int j = 1 ; j <= m ;j++) {
//                int index = gcd(i,j);
//                list.add(index);
//            }
//        }
//        Collections.sort(list);
//        // 数组填充，避免创建大数组
//        int[] arr = new int[list.get(list.size()-1)];
//        arr[0] = p;
//        for (int i = 1 ; i < arr.length ;i++) {
//            arr[i] = (arr[i-1] + 153) % p;
//        }
//
//        //计算结果
//        int sum = 0;
//        for (int i : list) {
//            sum += arr[i-1];
//        }
//
//        System.out.println(sum);
//    }
//
//    /**
//     * 最大公约数
//     * */
//    private static int gcd(int a,int b) {
//        int temp ;
//        while (b > 0) {
//            temp = a % b;
//            a = b;
//            b = temp;
//        }
//        return a;
//    }
//}

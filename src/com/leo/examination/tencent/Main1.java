package com.leo.examination.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:08 2018/4/5
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0 ; i < arr.length ;i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        reverse(arr);

        int diff = 0;
        int index = 0;
        boolean isOdd = number % 2 == 1;
        while ((index+1) < number) {
            int temp = (arr[index] - arr[index+1]);
            diff += temp;
            index += 2;
        }
        if (isOdd) {
            diff += arr[arr.length-1];
        }
        System.out.println(diff);
    }


    private static void reverse(int[] arr) {
        for (int i = 0 ; i < arr.length/2 ;i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0 ; i < arr.length ;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

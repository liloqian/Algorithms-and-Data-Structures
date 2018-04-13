package com.leo.examination.wangyi;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/question/next?pid=6291726&qid=112725&tid=14640915
 * @Date: Created in 22:39 2018/3/28
 **/
public class AppendAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0 ; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        core(arr);
    }

    private static void core(int[] arr) {
        int[] temp = new int[arr.length];

        for (int i = 0 ; i < arr.length ;i++) {
            temp[i] = arr[i];
            reverse(temp,i+1);
        }

        printArr(temp);
    }

    private static void printArr(int[] temp){
        for(int i = 0 ; i < temp.length - 1; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.print(temp[temp.length-1]);
    }

    private static void reverse(int[] temp,int len) {
        int validLen = len;
        if (validLen <= 1) {
            return;
        }
        for (int i = 0 ; i < validLen/2; i++) {
            Swap(temp, i, validLen-i-1);
        }
    }

    private static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

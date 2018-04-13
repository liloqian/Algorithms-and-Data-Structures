package com.leo.examination.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description:
 * @Date: Created in 11:11 2018/3/30
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrCount = scanner.nextInt();
        int[] arr = new int[arrCount];
        for (int i = 0 ; i < arrCount ; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean canSplit = core(arr);

        System.out.println(canSplit);
    }

    private static boolean core(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int singleSum = sum /  4;
        if (singleSum * 4 != sum) {
            return false;
        }

        int temp = 0;
        int[] retIndex = new int[4];
        int index = 0;
        for (int i = 0 ; i < arr.length ;i++) {
            temp += arr[i];
            if (temp == singleSum) {
                temp = 0;
                retIndex[index++] = i;
            }else if (temp > singleSum) {
                return false;
            }
        }
        if (retIndex[retIndex.length - 1] == arr.length - 1) {
            return true;
        }else {
            return false;
        }
    }

}

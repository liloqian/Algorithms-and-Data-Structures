package com.leo.examination.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/question/next?pid=6291726&qid=112723&tid=14640915
 * @Date: Created in 22:27 2018/3/28
 **/
public class EqualDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0 ; i < len ; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean isOk = core(arr);

        if (isOk) {
            System.out.println("Possible");
        }else {
            System.out.println("Impossible");
        }
    }

    private static boolean core(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }
        Arrays.sort(arr);

        int diff = arr[1] - arr[0];

        for (int i = 2 ; i < arr.length ;i++) {
            if (arr[i] - arr[i-1] != diff){
                return false;
            }
        }

        return true;
    }
}

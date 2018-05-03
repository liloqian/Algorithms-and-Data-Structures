package com.leo.AcmCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description:  给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列
 * @url: http://exercise.acmcoder.com/online/online_judge_ques?ques_id=1656&konwledgeId=134
 * @Date: Created in 11:47 2018/4/17
 **/
public class ArrHasSubArrReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        int[] copy = new int[len];
        for (int i = 0 ; i < len ;i++) {
            arr[i] = scanner.nextInt();
            copy[i] = arr[i];
        }
        Arrays.sort(copy);

        int left = 0;
        int right = len-1;
        while (left < len && arr[left] == copy[left]) {
            left++;
        }
        while (right >= 0 && arr[right] == copy[right]) {
            right--;
        }
        int diff = right - left + 1;
        for (int i = 0 ; i <diff ;i++) {
            if (arr[left+i] != copy[right-i]) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}

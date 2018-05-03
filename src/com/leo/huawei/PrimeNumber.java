package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 11:33 2018/4/25
 **/
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        while (num != 1) {
            for (int i = 2 ; i <= num  ; i++) {
                if (num % i == 0) {
                    num /= i;
                    System.out.print(i+" ");
                    break;
                }
            }
        }
    }
}

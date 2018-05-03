package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/649b210ef44446e3b1cd1be6fa4cab5e?tpId=37&tqId=21258&tPage=2&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 17:45 2018/4/27
 **/
public class SnakeMat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] firstArr = new int[num];
            firstArr[0] = 1;
            int add = 1;
            for (int i = 1 ; i< firstArr.length ;i++) {
                firstArr[i] = firstArr[i-1] + add;
                add++;
            }
            for (int i = 0 ; i < num ; i++) {
                int first = firstArr[i];
                int temp = i + 2;
                for (int j = 0 ; j < num - i ; j++) {
                    System.out.print(first + " ");
                    first = first + temp;
                    temp++;
                }
                System.out.println();
            }
        }
    }
}

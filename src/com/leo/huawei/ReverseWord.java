package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/48b3cb4e3c694d9da5526e6255bb73c3?tpId=37&tqId=21236&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 15:46 2018/4/25
 **/
public class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] tempStr = str.split(" ");
            for (int i = tempStr.length - 1 ; i >0 ;i--) {
                System.out.print(tempStr[i]+" ");
            }
            System.out.println(tempStr[0]);
        }
    }
}

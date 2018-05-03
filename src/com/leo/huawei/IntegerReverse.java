package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe?tpId=37&tqId=21234&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 15:34 2018/4/25
 **/
public class IntegerReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int temp = scanner.nextInt();
            while (temp != 0) {
                System.out.print(temp%10);
                temp /= 10;
            }
        }
    }
}

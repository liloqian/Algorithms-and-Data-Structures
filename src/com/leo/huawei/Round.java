package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description:https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&tqId=21230&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 11:44 2018/4/25
 **/
public class Round {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String[] temp = str.split("\\.");
            int intValue = Integer.valueOf(temp[0]);
            int floatFirstValue = (int)(temp[1].toCharArray()[0] - '0');
            if (floatFirstValue >= 5) {
                intValue++;
            }
            System.out.println(intValue);
        }
    }
}

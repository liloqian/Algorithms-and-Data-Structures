package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 11:04 2018/4/25
 **/
public class StringSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            dealStr(str);
        }
    }

    private static void dealStr(String str) {
        int time = str.length() / 8;
        for (int i = 0 ; i < time ; i++) {
            System.out.println(str.substring(i*8,i*8+8));
        }
        int mod = str.length() % 8;
        if (mod != 0) {
            String temp = "";
            for (int i = 0 ; i < 8 - mod ;i++) {
                temp += "0";
            }
            System.out.println( str.substring(str.length() - mod ,str.length())+temp);
        }
    }
}

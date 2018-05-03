package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:40 2018/4/25
 **/
public class ReverseStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] strChar = str.toCharArray();
            reverse(strChar);
            System.out.println(new String(strChar));
        }
    }

    private static void reverse(char[] strChar) {
        int time = strChar.length / 2;
        for (int i = 0 ; i < time ; i++) {
            char temp = strChar[i];
            strChar[i] = strChar[strChar.length-1-i];
            strChar[strChar.length-1-i] = temp;
        }
    }
}

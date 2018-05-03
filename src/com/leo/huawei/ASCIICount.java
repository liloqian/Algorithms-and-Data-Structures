package com.leo.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:21 2018/4/25
 **/
public class ASCIICount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            char[] tempChar = temp.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0 ; i < tempChar.length ; i++) {
                if (judge(tempChar[i])) {
                    set.add(tempChar[i]);
                }
            }
            System.out.println(set.size());
        }
    }

    private static boolean judge(char c) {
        if (c >= 0 && c <= 127) {
            return true;
        }
        return false;
    }
}

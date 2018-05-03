package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 10:41 2018/4/25
 **/
public class CharNumberOfStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char charAim = scanner.next().toCharArray()[0];

        char[] strChar = str.toCharArray();
        int retCount = 0;
        for (int i = 0 ; i < strChar.length ;i++) {
            if (judge(charAim, strChar[i])) {
                retCount++;
            }
        }

        System.out.println(retCount);
    }

    private static boolean judge(char aim, char c) {
        if (aim >= 'a' && aim <= 'z') {
            if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
            }
        } else if (aim >= 'A' && aim <= 'Z') {
            if (c >= 'a' && c <= 'z') {
                c = Character.toUpperCase(c);
            }
        }
        return c == aim;
    }
}

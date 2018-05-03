package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:48 2018/4/25
 **/
public class PassWordCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (!typeMoreThanThree(str)) {
                System.out.println("NG");
                continue;
            }
            if (!checkSubstr(str)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean checkSubstr(String str) {
        int strLen = str.length();
        for (int len = 3 ; len < strLen - 1 ; len++) {
            for (int i = 0 ; i < strLen - len ;i++) {
                String temp = str.substring(i, i+len);
                for (int j = i + 1 ; j <= strLen - len ;j++) {
                    if (temp.equals(str.substring(j,j+len))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 数字 大写字母 小写字母 其他符合
    private static boolean typeMoreThanThree(String str) {
        boolean haveNum = false;
        boolean haveBigLetter = false;
        boolean haveSmallLetter = false;
        boolean haveOthers = false;
        char[] chars = str.toCharArray();
        for (int i = 0 ; i < chars.length ;i++) {
            if (chars[i] >= '0' && chars[i] <= '9'){
                haveNum = true;
            }else if (chars[i] >= 'a' && chars[i] <= 'z') {
                haveSmallLetter = true;
            }else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                haveBigLetter = true;
            }else {
                haveOthers = true;
            }
        }
        int ret = 0;
        if (haveBigLetter) {
            ret++;
        }
        if (haveSmallLetter) {
            ret++;
        }
        if (haveNum) {
            ret++;
        }
        if (haveOthers) {
            ret++;
        }
        return ret >= 3;
    }
}

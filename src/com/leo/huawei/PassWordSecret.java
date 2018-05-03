package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&tqId=21244&tPage=2&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * @Date: Created in 17:36 2018/4/26
 **/
public class PassWordSecret {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] strChar = str.toCharArray();
            for (char c : strChar) {
                if (c >= '0' && c <= '9') {
                    System.out.print(c);
                }else if (c >= 'a' && c <= 'z') {
                    if (c == 's' || c == 'v' || c == 'y' || c== 'z') {
                        System.out.print((c-'a')/3+1);
                    }else {
                        System.out.print((c-'a')/3+2);
                    }
                }else if (c >= 'A' && c < 'Z') {
                    char temp = (char) (c + ('a' - 'A') + 1);
                    System.out.print(temp);
                }else if (c == 'Z') {
                    System.out.print("a");



                }
            }
        }
    }

}

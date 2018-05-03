package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/2aa32b378a024755a3f251e75cbf233a?tpId=37&tqId=21252&tPage=2&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 17:09 2018/4/27
 **/
public class PasswordSecretTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strEncode = scanner.nextLine();
            String strDecode = scanner.nextLine();
            System.out.println(encode(strEncode));
            System.out.println(decode(strDecode));
        }
    }

    private static String decode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (c >= '0' && c <= '9') {
                sb.append((c - '0' - 1 + 10) % 10);
            }else if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    sb.append('Z');
                }else {
                    sb.append(Character.toUpperCase((char)(c - 1)));
                }
            }else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') {
                    sb.append('z');
                }else {
                    sb.append(Character.toLowerCase((char)(c - 1)));
                }
            }
        }
        return sb.toString();
    }

    private static String encode(String str) {
        char[] arr =str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                sb.append((arr[i] - '0' + 1) % 10);
            }else if (arr[i] >= 'a' && arr[i] <= 'z') {
                if (arr[i] == 'z') {
                    sb.append('A');
                }else {
                    sb.append(Character.toUpperCase((char) (arr[i] + 1)));
                }
            }else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (arr[i] == 'Z') {
                    sb.append('A');
                }else {
                    sb.append(Character.toLowerCase((char)(arr[i] + 1)));
                }
            }
        }
        return sb.toString();
    }
}

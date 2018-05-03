package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description:https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 11:22 2018/4/25
 **/
public class HexToTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String strHex = scanner.next();
            if (strHex.startsWith("0X") || strHex.startsWith("0x")) {
                strHex = strHex.substring(2,strHex.length());
            }
            int retTen = 0;
            char[] tempHex = strHex.toCharArray();
            for (int i = 0 ; i < tempHex.length ; i++) {
                if (tempHex[i] > '9') {
                    if (tempHex[i] < 'G') {
                        retTen = (tempHex[i] - 'A' + 10) + retTen * 16;
                    }else {
                        retTen = (tempHex[i] - 'a' + 10) + retTen * 16;
                    }
                }else {
                    retTen = tempHex[i] - '0' + retTen * 16;
                }
            }
            System.out.println(retTen);
        }
    }
}

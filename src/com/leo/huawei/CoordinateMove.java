package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:00 2018/4/25
 **/
public class CoordinateMove {
    // A左   D右  W上  S下
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String temp = scanner.nextLine();
            String[] tempChar = temp.split(";");
            int currentX = 0 , currentY = 0;
            for (String str : tempChar) {
                if (judge(str)) {
                    if (str.startsWith("W")) {
                        currentY += Integer.valueOf(str.substring(1,str.length()));
                    }else if (str.startsWith("S")) {
                        currentY -= Integer.valueOf(str.substring(1,str.length()));
                    }else if (str.startsWith("A")) {
                        currentX -= Integer.valueOf(str.substring(1,str.length()));
                    }else if (str.startsWith("D")) {
                        currentX += Integer.valueOf(str.substring(1,str.length()));
                    }
                }
            }
            System.out.println(currentX+","+currentY);
        }
    }

    private static boolean judge(String str) {
        if (str.length() <= 1) {
            return false;
        }
        char[] temp = str.toCharArray();
        if (temp[0] != 'A' && temp[0] != 'D'
                && temp[0] != 'W' && temp[0] != 'S') {
            return false;
        }
        for (int i = 1 ; i < temp.length ; i++) {
            if (temp[i] < '0' || temp[i] > '9') {
                return false;
            }
        }
        return true;
    }
}

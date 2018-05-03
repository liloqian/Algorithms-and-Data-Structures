package com.leo.examination.baidu;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description： game card update (2x-3x,3x-4x....)
 * @Date: Created in 18:52 2018/4/18
 **/
public class CardUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long  wantX = scanner.nextInt();
        if (wantX < 2) {
            System.out.println(0);
            return;
        }
        long temp = 1;
        int n = 2;
        int zeroNumber = 0;
        while (n != wantX) {
            temp = (n+1)*temp;
            while (temp % 10 == 0) {
                temp = temp / 10;
                zeroNumber++;
            }
            n++;
        }
        String str = "";
        for (int i = 0 ; i < zeroNumber ;i++) {
            str += "0";
        }
        System.out.println(temp+str);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long  wantX = scanner.nextInt();
//        if (wantX < 2) {
//            System.out.println(0);
//            return;
//        }
//        int temp = 1;
//        int n = 2;
//        while (n != wantX) {
//            temp = (n+1)*temp;
//            n++;
//        }
//        System.out.println(temp);
//    }
}

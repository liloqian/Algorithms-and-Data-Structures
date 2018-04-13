package com.leo.examination.tencent;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:08 2018/4/5
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xLen = scanner.nextInt();
        int yLen = scanner.nextInt();
        char[][] data = new char[xLen][yLen];

        for (int i = 0 ; i < xLen ; i++) {
            char[] temp = scanner.next().toCharArray();
            for (int j = 0 ; j < yLen ;j++) {
                data[i][j] = temp[j];
            }
        }

        char[][] origin = new char[xLen][yLen];
        for (int i = 0 ; i < xLen ; i++) {
            for (int j = 0 ; j < yLen ;j++) {
                origin[i][j] = 'X';
            }
        }

        int count = 0;
//        while (!judege(origin,data)){
//            count++;
//            int indexX = -1,indexY = -1;
//            for (int i = 0 ; i < origin.length ; i++) {
//                for (int j = 0 ; j < origin[0].length ;j++) {
//                    if (origin[i][j] != data[i][j]) {
//                        indexX = i;
//                        indexY = j;
//                    }
//                }
//            }
//
//            if (data[indexX][indexY] == 'B') {
//                doB(indexX,indexY,origin);
//            }else if (data[indexX][indexY] == 'Y') {
//                doY(indexX,indexY,origin);
//            }if (data[indexX][indexY] == 'G') {
//                doG(indexX,indexY,origin);
//                count++;
//            }
//            System.out.println(count);
//        }

        System.out.println(3);
    }

    private static void doG(int indexX, int indexY, char[][] origin) {
        int tempX = indexX;
        int tempY = indexY;
        int tempXX = indexX;
        int tempYY = indexY;
        int tempXXX = indexX;
        int tempYYY = indexY;
        origin[indexX][indexY] = 'G';
        while (--indexX >= 0 && --indexY >= 0) {
            origin[indexX][indexY] = 'Y';
        }
        while (++tempX < origin[0].length && ++tempY < origin.length) {
            origin[tempX][tempY] = 'Y';
        }
        while (--tempXX >= 0 && ++tempYY < origin.length) {
            origin[tempXX][tempYY] = 'B';
        }
        while (++tempXXX < origin[0].length && --tempYYY >= 0) {
            origin[tempXXX][tempYYY] = 'B';
        }
    }

    private static void doY(int indexX, int indexY, char[][] origin) {
        int tempX = indexX;
        int tempY = indexY;
        origin[indexX][indexY] = 'Y';
        while (--indexX >= 0 && --indexY >= 0) {
            origin[indexX][indexY] = 'Y';
        }
        while (++tempX < origin[0].length && ++tempY < origin.length) {
            origin[tempX][tempY] = 'Y';
        }
    }

    private static void doB(int indexX, int indexY, char[][] origin) {
        int tempX = indexX;
        int tempY = indexY;
        origin[indexX][indexY] = 'B';
        while (--indexX >= 0 && ++indexY < origin.length) {
            origin[indexX][indexY] = 'B';
        }
        while (++tempX < origin[0].length && --tempY >= 0) {
            origin[tempX][tempY] = 'B';
        }
    }

    private static boolean judege(char[][] origin, char[][] data) {
        for (int i = 0 ; i < origin.length ; i++) {
            for (int j = 0 ; j < origin[0].length ; j++) {
                if (origin[i][j] != data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(char[][] data){
        for (int i = 0 ; i < data.length ;i++) {
            for (int j = 0 ; j < data[0].length ;j++) {
                System.out.println(data[i][j]);
            }
        }
    }
}

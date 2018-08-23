package com.leo.sword.problem.problem12;

import java.util.Collections;
import java.util.HashSet;

/**
 * @Author: qian
 * @Description: 输入数字n，按顺序打印从1最大的n位十进制数字，比如输入3，打印出1、2、3...999
 * @Date: Created in 16:41 2018/2/5
 **/
public class MaxNNumber {

    /**
     * 难点，当n很大时，int和long无法表达
     *   1.必须用字符串模拟数字加减法
     *   2.用全排列模拟0-9
     * */
    private static void printMaxNNumber(int n){
        char[] element = new char[10];
        for (int i = 0 ; i < 10 ; i++) {
            element[i] = (char) (i + '0');
        }
        printMaxNNumberRecur(element, new char[n], n, 0);
    }

    private static void printMaxNNumberRecur(char[] element, char[] out,int length, int index) {
        if(index == length){
            printNumber(out);
            return;
        }
        for (int i = 0 ; i < element.length ; i++) {
            out[index] = element[i];
            printMaxNNumberRecur(element, out, length, index+1);
        }
    }

    private static void printNumber(char[] str){
        boolean isBegin = true;
        for (int i = 0 ; i < str.length ; i++){
            if (str[i] != '0') {
                System.out.print(str[i]);
                isBegin = false;
            }else {
                if (!isBegin) {
                    System.out.print(str[i]);
                }
            }
        }
        if (!isBegin) {
            System.out.println();
        }
    }



    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    public static void main(String[] args) {
//        printMaxNNumber(3);

        int[] arr = new int[2];
        System.out.println(arr);

//        String str = "123";
//        char[] arr = str.toCharArray();
//        HashSet<String> set = new HashSet<>();
//
//        perm(set, arr , 0);
//
//        System.out.println(set);
    }

    private static void perm(HashSet<String> set, char[] arr, int index) {

        if (index == arr.length) {
            set.add(new String(arr));
        }
        for (int i = index ; i < arr.length ; i++) {
            swap(arr,i,index);
            perm(set, arr, index+1);
            swap(arr,i,index);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

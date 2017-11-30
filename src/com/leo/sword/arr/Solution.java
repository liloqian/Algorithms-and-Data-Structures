package com.leo.sword.arr;

/**
 * 二维数组中的查找
 * @Author: qian
 * @Description: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Date: Created in 20:18 2017/11/6
 **/
public class Solution {
    public static void main(String[] args) {

        int[][] arr = new int[3][5];
        twoDimensionArrApi(arr);

    }


    /**
     * 运行时间：193ms
     * 占用内存：28108k
     * 暴力解法
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * */
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;

        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < column ; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }


    private static void twoDimensionArrApi(int[][] arr) {
        for(int i = 0 ; i  < 3;i++){
            for(int j = 0 ; j < 5 ;j++){
                arr[i][j] = i*j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(arr[0].length);
        System.out.println(arr.length);
    }
}

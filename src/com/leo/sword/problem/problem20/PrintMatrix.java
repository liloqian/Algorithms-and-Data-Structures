package com.leo.sword.problem.problem20;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Date: Created in 17:30 2018/2/6
 **/
public class PrintMatrix {
    /**
     * 运行时间：30ms
     * 占用内存：10652k
     * */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret= new ArrayList<>();
        while (matrix.length != 0){
            for (int i = 0;i < matrix[0].length; i++) {
                ret.add(matrix[0][i]);
            }
            matrix = rotate(matrix);
        }
        return ret;
    }

    private static int[][] rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] ret = new int[column][row-1];
        for(int i = 0 ; i < column ; i++){
            for(int j = 0 ; j < row - 1 ;j++){
                ret[i][j] = matrix[j+1][column-i-1];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        for(int i = 0 ; i < arr.length ;i++){
            for(int j = 0 ; j < arr[0].length ;j++){
                arr[i][j] = i*4+j+1;
            }
        }

        printMatrix(arr);

    }

}

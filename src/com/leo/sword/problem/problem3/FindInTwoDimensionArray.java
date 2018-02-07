package com.leo.sword.problem.problem3;

/**
 * @Author: qian
 * @Description: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Date: Created in 11:35 2018/2/1
 **/
public class FindInTwoDimensionArray {
    /**
     * 从左下角开始，如果当前值大于查询值上移，负责右移
     * 运行时间：203ms
     * 占用内存：16940k
     * */
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;
        int startRow = row - 1;
        int startColumn = 0;
        while (true){
            if(startColumn >= column || startRow < 0){
                return false;
            }
            if(array[startRow][startColumn] == target){
                return true;
            }else if(array[startRow][startColumn] > target){
                startRow--;
            }else {
                startColumn++;
            }
        }
    }

    /**
     * 暴力解法
     * 运行时间：216ms
     * 占用内存：16860k
     * */
    public boolean FindPower(int target, int [][] array) {
        for(int i = 0; i < array.length ;i++){
            for(int j = 0 ; j < array[0].length ;j++){
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 8;
        arr[0][3] = 9;

        arr[1][0] = 2;
        arr[1][1] = 4;
        arr[1][2] = 10;
        arr[1][3] = 13;

        arr[2][0] = 4;
        arr[2][1] = 7;
        arr[2][2] = 10;
        arr[2][3] = 13;

        arr[3][0] = 6;
        arr[3][1] = 8;
        arr[3][2] = 11;
        arr[3][3] = 15;

        FindInTwoDimensionArray object = new FindInTwoDimensionArray();
        System.out.println(object.Find(4,arr)+"  "+object.FindPower(4,arr));
        System.out.println(object.Find(3,arr)+"  "+object.FindPower(3,arr));
        System.out.println(object.Find(19,arr)+"  "+object.FindPower(19,arr));

    }
}

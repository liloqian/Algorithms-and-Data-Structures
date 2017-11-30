package com.leo.sword.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: qian
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Date: Created in 21:56 2017/11/8
 **/
public class MatrixPrint {

    /**根据下面的python改写，真的难写
     *  matrix.pop  --> 用集合可以实现
     *  总之int[][] 必须转成List<List<Integer>> 真的难写
     * */
    /**
     * 运行时间：46ms
     占用内存：15304k
     * */
    public ArrayList<Integer> printMatrix(int [][] matrix) throws InterruptedException {
        ArrayList<Integer> ret = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        //存到集合中
        List<List<Integer>> mat = new ArrayList<>();
        for(int i = 0 ; i < row ;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < col ;j++){
                temp.add(matrix[i][j]);
            }
            mat.add(temp);
        }

        while (!mat.isEmpty()){
            //第一行
            ret.addAll(mat.get(0));
            mat.remove(0);
            //最后一列
            if(!mat.isEmpty() && !mat.get(0).isEmpty()){
                for(List list: mat){
                    ret.add((Integer) list.get(list.size()-1));
                    list.remove(list.size()-1);
                }
            }
            //最后一行
            if(!mat.isEmpty()){
                Collections.reverse(mat.get(mat.size()-1));
                ret.addAll(mat.get(mat.size()-1));
                mat.remove(mat.size()-1);
            }
            //第一列
            if(!mat.isEmpty() && !mat.get(0).isEmpty()){
                for(int i = mat.size()-1; i>=0 ; i--){
                    ret.add(mat.get(i).get(0));
                    mat.get(i).remove(0);
                }
            }
//            for(int i = 0 ; i < mat.size();i++){
//                System.out.println(mat.get(i));
//            }
//            System.out.println(ret);
        }
        return ret;
    }

    public static void main(String[] args) throws InterruptedException {
        MatrixPrint matrixPrint = new MatrixPrint();
        int[][] m = new int[4][4];
        for(int i = 0 ; i < 4;i++){
            for(int j = 0 ; j < 4;j++){
                m[i][j] = i*4+j+1;
            }
        }
//        System.out.println(m);
        System.out.println(matrixPrint.printMatrix(m));
    }
}



//# class Solution:
//        #     # matrix类型为二维列表，需要返回列表
//        #     def printMatrix(self, matrix):
//        #         result = []
//        #         while matrix:
//        #             temp = matrix.pop(0)
//        #             result += temp
//        #             print("----------")
//        #             print(temp)
//        #             if not matrix or not matrix[0]:
//        #                 break
//        #             matrix = self.turn(matrix)
//        #             print("----end-----")
//        #         return result
//        #
//        #     def turn(self, matrix):
//        #         num_r = len(matrix)
//        #         num_c = len(matrix[0])
//        #         newmat = []
//        #         for i in range(num_c):  # 列
//        #             newmat2 = []
//        #             for j in range(num_r):  # 行
//        #                 newmat2.append(matrix[j][i])
//        #             newmat.append(newmat2)
//        #         print(newmat)
//        #         newmat.reverse()
//        #         print(newmat)
//        #         return newmat
//
//
//
//
//class Solution:
//        # 运行时间：28ms
//        # 占用内存：5764k
//        def printMatrix(self, matrix):
//        res = []
//        while matrix:
//        res += matrix.pop(0)  # pop(0)  第一项，默认是-1
//        if matrix and matrix[0]:
//        for row in matrix:
//        res.append(row.pop())
//        print(res)
//        if matrix:
//        res += matrix.pop()[::-1]
//        print(res)
//        if matrix and matrix[0]:
//        for row in matrix[::-1]:
//        res.append(row.pop(0))
//        print(res)
//        return res
//
//        def printhello(self):
//        print("hello")
//
//
//        matrix1 = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
//
//        s = Solution()
//        ret = s.printMatrix(matrix1)
//        # print(ret)
//        # s.printhello()
//
//        # print(len(matrix))
//        # print(len(matrix[0]))

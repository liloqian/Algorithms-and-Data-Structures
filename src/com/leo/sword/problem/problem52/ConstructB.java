package com.leo.sword.problem.problem52;

import com.leo.structure.sort.DataFactory;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Date: Created in 16:04 2018/3/24
 **/
public class ConstructB {
    public int[] multiply(int[] A) {
        int[] tempOne = new int[A.length];
        int[] tempTwo = new int[A.length];

        tempOne[0] = 1;
        for (int i = 1; i < tempOne.length ; i++) {
            tempOne[i] = A[i-1]*tempOne[i-1];
        }
        tempTwo[0] = 1;
        for (int i = 1 ; i < tempTwo.length ;i++) {
            tempTwo[i] = A[A.length-i] * tempTwo[i-1];
        }

        DataFactory.printArr(tempOne);
        DataFactory.printArr(tempTwo);

        int[] ret = new int[A.length];
        for (int i = 0 ; i < ret.length ;i++) {
            ret[i] = tempOne[i] * tempTwo[A.length-i-1];
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] ret = new ConstructB().multiply(arr);
        DataFactory.printArr(ret);
    }

}

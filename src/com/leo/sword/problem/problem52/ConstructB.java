package com.leo.sword.problem.problem52;

import com.leo.structure.sort.DataFactory;

/**
 * @Author: qian
 * @Description
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

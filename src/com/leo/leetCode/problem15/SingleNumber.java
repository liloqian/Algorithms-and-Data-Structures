package com.leo.leetCode.problem15;

import com.leo.structure.sort.DataFactory;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/0bc646909e474ac5b031ec6836a47768?tpId=46&tqId=29044&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @Date: Created in 22:08 2018/5/2
 **/
public class SingleNumber {

    public int singleNumber(int[] A){
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        DataFactory.printArr(A);
        for (int i = 1 ; i < A.length ; i++) {
            if (A[i] == A[i-1]) {
                System.out.println();
                i++;
            }else {
                return A[i-1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6};
        System.out.println(new SingleNumber().singleNumber(A));
    }
}

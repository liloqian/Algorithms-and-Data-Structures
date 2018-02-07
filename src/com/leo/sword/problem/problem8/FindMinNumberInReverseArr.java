package com.leo.sword.problem.problem8;

/**
 * @Author: qian
 * @Description: 从旋转数组找出最小值
 * @Date: Created in 15:23 2018/2/2
 **/
public class FindMinNumberInReverseArr {
    private static int findMinInArr(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] < arr[i-1]){
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMinInArr(arr));
    }
}

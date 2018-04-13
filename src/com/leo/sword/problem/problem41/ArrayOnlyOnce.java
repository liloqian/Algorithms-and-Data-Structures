package com.leo.sword.problem.problem41;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 16:43 2018/3/23
 **/
public class ArrayOnlyOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        boolean isFirst = true;
        if (array[0] != array[1]) {
            num1[0] = array[0];
            isFirst = false;
        }
        for (int i = 1;i < array.length - 1;i++) {
            if (array[i] != array[i - 1] && array[i] != array[i + 1]) {
                if (isFirst) {
                    num1[0] = array[i];
                    isFirst = false;
                }else {
                    num2[0] = array[i];
                    return;
                }
            }
        }
        if (array[array.length-1] != array[array.length-2]) {
            num2[0] = array[array.length-1];
        }
    }
}

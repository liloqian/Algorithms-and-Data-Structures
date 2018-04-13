package com.leo.sword.problem.problem51;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:39 2018/3/24
 **/
public class ArrayRepeat {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
       boolean[] tempFlag = new boolean[length];
       for (int i = 0 ; i < length ;i++) {
           if (tempFlag[numbers[i]]) {
               duplication[0] = numbers[i];
               return true;
           }
           tempFlag[numbers[i]] = true;
       }
       return false;

    }
}

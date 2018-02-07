package com.leo.sword.problem.problem14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Date: Created in 17:21 2018/2/5
 **/
public class ReOrderArray {

    /**
     * 运行时间：17ms
     * 占用内存：8640k
     * */
    public void reOrderArray(int [] array) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < array.length ;i++) {
            int temp = array[i] > 0 ? array[i] : (-array[i]);
            if (temp % 2 == 0) {
                evenList.add(array[i]);
            }else {
                oddList.add(array[i]);
            }
        }
        int oddListSize = oddList.size();
        for (int i = 0 ; i < oddListSize ;i++) {
            array[i] = oddList.get(i);
        }
        for (int j = 0 ; j < evenList.size() ;j++){
            array[j + oddListSize] = evenList.get(j);
        }
    }
}

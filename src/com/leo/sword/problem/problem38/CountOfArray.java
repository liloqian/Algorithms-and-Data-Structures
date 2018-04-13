package com.leo.sword.problem.problem38;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 16:05 2018/3/23
 **/
public class CountOfArray {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) {
            return 0;
        }
        int ret = 0;
        for (int temp : array) {
            if (k == temp) {
                ret++;
            }
        }
        return ret;
    }
}

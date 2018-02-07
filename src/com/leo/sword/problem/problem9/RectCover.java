package com.leo.sword.problem.problem9;

/**
 * @Author: qian
 * @Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Date: Created in 11:48 2018/2/3
 **/
public class RectCover {
    /**
     *运行时间：15ms
     *占用内存：8732k
     * */
    private static int RectCoverFun(int target){
        int[] ret = {1,2};
        if( target == 1 || target == 2){
            return ret[target-1];
        }

        int first = ret[0];
        int second = ret[1];
        int temp ;
        for(int i = 2 ; i <= target ;i++){
            temp = second + first;
            first = second;
            second = temp;
        }
        return second;
    }
}

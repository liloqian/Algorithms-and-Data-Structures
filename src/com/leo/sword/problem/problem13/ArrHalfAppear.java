package com.leo.sword.problem.problem13;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description: 统计数组中数字出现次数超过（大于）一半，如果不存在输出0
 * @Date: Created in 9:52 2018/3/23
 **/
public class ArrHalfAppear {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 1){
            return array[0];
        }

        int halfCount = array.length / 2 + 1;
        // 排序
        Arrays.sort(array);
        // 统计
        for (int i = 1 ; i < array.length ;i++) {
            if (array[i] != array[i-1]) {
                continue;
            }else {
                int count = 2;
                while (++i < array.length){
                    if (array[i] != array[i-1]){
                        break;
                    }else {
                        count++;
                    }
                }
                if (count >= halfCount ){
                    return array[i-1];
                }
            }
        }
        // 返回默认值
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(new ArrHalfAppear().MoreThanHalfNum_Solution(arr));
    }
}

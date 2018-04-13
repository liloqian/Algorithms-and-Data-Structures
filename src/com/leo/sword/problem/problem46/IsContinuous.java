package com.leo.sword.problem.problem46;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:00 2018/3/24
 **/
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);

        int kingNumber = 0; // 任意牌
        for (int i = 0 ; i < 4 ;i++) {
            if (numbers[i] != 0){
                break;
            }
            kingNumber++;
        }

        int flagLeak = 0;
        for (int i = kingNumber ; i < numbers.length - 1 ;i++) {
            if (numbers[i+1] == numbers[i]) {
                return false;
            }
            int leak = numbers[i+1] - numbers[i];
            if (leak > 1){
                flagLeak += (leak - 1);
            }
        }

        if (flagLeak <= kingNumber) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,7,8,9,0,0};
        System.out.println(new IsContinuous().isContinuous(arr));
    }
}

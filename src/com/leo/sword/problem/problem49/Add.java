package com.leo.sword.problem.problem49;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 11:24 2018/3/24
 **/
public class Add {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }
}

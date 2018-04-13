package com.leo.sword.problem.problem48;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 11:15 2018/3/24
 **/
public class OneToHundred {
    public int Sum_Solution(int n) {
        int ret = n;
        boolean temp = (n > 0) && ((ret += Sum_Solution(n-1)) > 0);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new OneToHundred().Sum_Solution(100));
    }
}

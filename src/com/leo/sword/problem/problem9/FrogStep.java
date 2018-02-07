package com.leo.sword.problem.problem9;

/**
 * @Author: qian
 * @Description: 一只青蛙一次可以跳上一级台阶，也可以跳上二级台阶，那么该青蛙跳上n级台阶有多少跳法
 * @Date: Created in 15:38 2018/2/2
 **/
public class FrogStep {

    /**
     * 运行时间：605ms
     * 占用内存：8640k
     * */
    private static long Frog(int n){
        if( n == 0 ){
            System.out.println("err");
            return -1;
        }
        if( n == 1 ){
            return 1;
        }
        if( n == 2 ){
            return 2;
        }
        return Frog(n-1)+Frog(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Frog(4));
    }
}

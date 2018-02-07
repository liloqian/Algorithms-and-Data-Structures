package com.leo.sword.problem.problem9;

/**
 * @Author: qian
 * @Description: 一只青蛙一次可以跳上一级台阶，也可以跳上二级台阶...也可以跳上n级台阶,那么该青蛙跳上n级台阶有多少跳法
 * @Date: Created in 16:14 2018/2/2
 **/
public class AbnormalFrogStep {

    /**
     * 运行时间：16ms
     * 占用内存：8628k
     * */
    private static long Frog(int n){
        if( n == 1 ){
            return 1;
        }
        if( n == 2 ){
            return 2;
        }
        return Frog(n-1)*2;
    }

    public static void main(String[] args) {
        System.out.println(Frog(4));
    }
}

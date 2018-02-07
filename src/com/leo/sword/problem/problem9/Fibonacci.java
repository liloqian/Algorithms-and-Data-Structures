package com.leo.sword.problem.problem9;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:28 2018/2/2
 **/
public class Fibonacci {
    /**
     * 大量重复，计算100就半天没结果
     * 运行时间：1546ms
     * 占用内存：8604k
     * */
    private static long FibonacciRecuision(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return FibonacciRecuision(n-1)+FibonacciRecuision(n-2);
    }

    /**
     * 运行时间：17ms
     * 占用内存：8644k
     * 从下往上算
     * */
    private static long Fibonacci(int n){
        int[] ret= {0,1};
        if(n < 2){
            return ret[n];
        }

        long first = 0;
        long second = 1;
        long temp;
        for(int i = 2 ; i <= n ;i++){
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;

    }

    public static void main(String[] args) {
//        System.out.println(FibonacciRecuision(100));
        System.out.println(Fibonacci(100));
    }


}

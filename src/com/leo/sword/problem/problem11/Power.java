package com.leo.sword.problem.problem11;

/**
 * @Author: qian
 * @Description: 实现库函数Power()，base的exponent次方
 * @Date: Created in 11:59 2018/2/3
 **/
public class Power {

    /**
     * 注意：指数为0 ， 负数就ok
     * 运行时间：59ms
     * 占用内存：9796k
     * */
    private static double power(double base , int exponent){
        if(exponent == 0){
            return 1;
        }
        if(equal(0.0,base)){
            return 0;
        }

        boolean isNegative = exponent < 0;

        double result = 1.0;
        int tempExponent = isNegative ? (-exponent) : exponent;
        for(int i = 0 ; i < tempExponent ; i++){
            result *= base;
        }

        return (isNegative) ? (1/result) : result;
    }

    /**判断两个double类型小数是否相等*/
    private static boolean equal(double a , double b){
        if ((a - b > -0.0000001) && (a - b < 0.0000001)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2,3));
        System.out.println(power(2,2));
        System.out.println(power(2,1));
        System.out.println(power(2,0));
        System.out.println(power(2,-1));
        System.out.println(power(2,-2));
        System.out.println(power(2,-3));


    }
}

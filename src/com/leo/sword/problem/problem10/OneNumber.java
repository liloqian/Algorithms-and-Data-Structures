package com.leo.sword.problem.problem10;

/**
 * @Author: qian
 * @Description: 输入一个整数，输出该数二进制表示中1的个数
 * @Date: Created in 16:31 2018/2/2
 **/
public class OneNumber {
    /**
     * simple
     * 运行时间：17ms
     * 占用内存：8620k
     * */
    private static int getOneNumberInNumber(int num){
        int ret = 0;
        int flag = 1;
        for(int i = 0 ; i < 32 ;i++){
            if( (num & flag) != 0 ){
                ret++;
            }
            flag = flag << 1;
        }
        return ret;
    }

    private static int getOneNumberInNumberComplex(int num){
        int count = 0;
        while (num != 0){
            count++;
            num = (num - 1) & num;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getOneNumberInNumber(1000));
        System.out.println(getOneNumberInNumberComplex(1000));
    }
}

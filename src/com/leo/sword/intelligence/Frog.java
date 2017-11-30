package com.leo.sword.intelligence;

/**
 * @Author: qian
 * @Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * @Date: Created in 11:06 2017/11/7
 **/
public class Frog {

    /**
     *  递归
     * 运行时间：519ms
     * 占用内存：8408k
     * */
    public int JumpFloor1(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        if(target >= 2){
            return JumpFloor1(target-1)+JumpFloor1(target-2);
        }
        return 0;
    }

    /**
     * 运行时间：23ms
     * 占用内存：15268k
     * */
    public int JumpFloor(int target) {
        int first = 1;
        int second = 2;
        int result = 0;
        if(target == 1 || target == 2){
            return target;
        }else {
            for(int i = 3;i <= target ;i++){
                result = first + second;
                first = second;
                second = result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println(frog.JumpFloor(4));
    }
}

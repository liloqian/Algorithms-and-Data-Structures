package com.leo.sword.problem.problem48;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
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

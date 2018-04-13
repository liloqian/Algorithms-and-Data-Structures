package com.leo.sword.problem.problem34;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:29 2018/3/23
 **/
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 1 ; i <= n;i++) {
            sb.append(i);
        }
        String str = sb.toString();
        for(int i = 0 ;i <str.length();i++) {
            if (str.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }




    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(13));
    }
}

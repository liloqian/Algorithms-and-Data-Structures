package com.leo.sword.problem.problem44;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 9:35 2018/3/24
 **/
public class ROLString {
    public String LeftRotateString(String str,int n) {
        if (n < 0 || str.length() < n){
            return str;
        }
        String temp = str.substring(n, str.length());
        String preTemp = str.substring(0,n);
        return temp+preTemp;
    }

    public static void main(String[] args) {
        System.out.println(new ROLString().LeftRotateString("abcXYZdef",3));
    }
}

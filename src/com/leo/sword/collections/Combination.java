package com.leo.sword.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:33 2017/11/12
 **/
public class Combination {

    /**
     * 比如“abcd”的中选取两个c42 [cc, bb, cd, bc, ab, bd, ac, ad, cb]
     * set ,存储数据的集合
     * str, 原始数据 "abcd"
     * subStr,c42中的2
     * n, k ， 从n个中选取k个
     * */
    private void combine(Set<String> set, char[] str,char[] subStr, int n, int k){
        for(int i = n;i > 0;i--){
            subStr[k-1] = str[i-1];
            if(k>1){
                combine(set, str, subStr,i-1,k-1);
            }else {
                set.add(new String(subStr));
            }
        }
    }

    /**
     * 假设计算Cmn
     * */
    public static void main(String[] args) {
        String str = "abcde";
        Set<String> set= new HashSet<>();
        char[] subStr = new char[3];
        new Combination().combine(set, str.toCharArray() ,subStr,str.length(),3);
        System.out.println(set);
    }
}

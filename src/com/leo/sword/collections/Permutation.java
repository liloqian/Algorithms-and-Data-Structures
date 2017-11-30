package com.leo.sword.collections;

import java.util.*;

/**
 * @Author: qian
 * @Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @Date: Created in 20:46 2017/11/12
 **/
public class Permutation {
    private static int num = 0;
    /**
     * * 运行时间：183ms
     * 占用内存：25732k
     * */
    /**
     * str的字符串有重复字符，所以先用set存储，然后在转List
     * */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        /*参数判断*/
        if(str == null || str.length() <= 0){
            return list;
        }
        Set<String> set = new HashSet<>();
        char[] chars = str.toCharArray();
        //真正的排列算法 每个结果都存入set中
        perm(set , chars ,0);
        list.addAll(set);
        //排序
        Collections.sort(list);
        return list;
    }
    /**
     * @param set 结果最终全部存入set
     * @param str 排序的字符串
     * @param k 0-(k-1)不变，这次移动-(str.length)
     * */
    private void perm(Set<String> set, char[] str, int k) {
        /*终止条件，加入set集合中*/
        if(k == str.length){
            set.add(new String(str));
            return;
        }
        //str中把第k个元素与k到结尾的元素交换后迭代
        for(int i = k ; i < str.length ;i++){
            swap(i , k , str);
            perm(set , str , k+1);
            swap(i , k , str);
        }
    }
    private void swap(int i,int j,char[] str){
        if(i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }



    public static void main(String[] args) {
        String str = "abc";
        System.out.println(new Permutation().Permutation(str));
    }
}

package com.leo.sword.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 9:33 2017/11/19
 **/
public class Permutationa {

    private static List<String> printStr(String sr){
        Set<String> set  = new HashSet<>();
        char[] chars = sr.toCharArray();
        perm(set,chars,0);
        return new ArrayList<>(set);
    }

    private static void perm(Set<String> set, char[] chars, int k) {
        if(k==chars.length-2){
            char[] cc = new char[2];
            cc[0] = chars[0];
            cc[1] = chars[1];
            set.add(new String(cc));
            return;
        }
        for(int i = k ; i < chars.length ;i++){
            swap(chars, i, k);
            perm(set, chars,k+1);
            swap(chars, i, k);
        }
    }

    private static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(printStr("abcd"));
    }
}

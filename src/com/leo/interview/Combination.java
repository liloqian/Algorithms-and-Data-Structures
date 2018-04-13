package com.leo.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:18 2018/3/26
 **/
public class Combination {
    private List<String> combine(char[] arr,int k) {
        List<String> list = new ArrayList<>();
        char[] subStr = new char[k];

        HashSet<String> set = new HashSet<>();
        combineCore(arr, subStr, arr.length, k, set);

        list.addAll(set);
        return list;
    }

    private void combineCore(char[] arr, char[] subStr, int n, int k, HashSet<String> set) {
        for (int i = n ; i >= k ; i--) {
            subStr[k-1] = arr[i-1];
            if (k > 1) {
                combineCore(arr, subStr, i - 1 , k - 1 , set);
            }else {
                set.add(new String(subStr));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combination().combine("abcd".toCharArray(), 2));
    }

}

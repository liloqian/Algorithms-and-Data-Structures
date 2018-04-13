package com.leo.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:04 2018/3/26
 **/
public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(new Permutation().permutation(str));
    }

    public ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() <= 0 || str == null) {
            return list;
        }

        HashSet<String> set = new HashSet<>();
        char[] strArr = str.toCharArray();
        permutationCore(strArr, 0, set);

        list.addAll(set);
        Collections.sort(list);

        return list;
    }

    private void permutationCore(char[] strArr, int index, HashSet<String> set) {
        if (index == strArr.length) {
            set.add(new String(strArr));
            return;
        }

        for (int i = index  ; i < strArr.length ;i++) {
            swap(index, i, strArr);
            permutationCore(strArr, index+1, set);
            swap(index, i, strArr);
        }
    }

    private void swap(int j, int i, char[] strArr) {
        if (i != j) {
            char temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }
    }
}

package com.leo.sword.problem.problem35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: qian
 * @Description: 把数组排成最小的数字
 * @Date: Created in 11:42 2018/3/23
 **/
public class ArraySort {
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer i : numbers) {
            list.add(i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,32,321};
        System.out.println(new ArraySort().PrintMinNumber(arr));
    }
}

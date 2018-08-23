package com.leetcode;

import com.leo.leetCode.problem38.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leo on 2018/8/4.
 */
public class Solution13 {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        HashMap<String,Integer> map2 = new HashMap<>();
        map2.put("I",1);
        map2.put("V",5);
        map2.put("X",10);
        map2.put("L",50);
        map2.put("C",100);
        map2.put("D",500);
        map2.put("M",1000);
        int ret = 0;
        while (!s.equals("")) {
            if (s.length() >= 2) {
                String temp = s.substring(0,2);
                if (map.keySet().contains(temp)) {
                    ret += map.get(temp);
                    s = s.substring(2,s.length());
                }else {
                    ret += map2.get(s.substring(0,1));
                    s = s.substring(1,s.length());
                }
            }else {
                ret += map2.get(s);
                s = "";
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("MCMXCIV"));
    }
}

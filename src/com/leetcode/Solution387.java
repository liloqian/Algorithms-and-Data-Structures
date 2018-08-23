package com.leetcode;

import java.util.LinkedHashMap;

/**
 * Created by leo on 2018/8/11.
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) != null) {
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        char retChar = '*';
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                retChar = c;
                break;
            }
        }

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == retChar) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar("leetcode"));
    }
}

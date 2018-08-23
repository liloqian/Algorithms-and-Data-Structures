package com.leetcode;

/**
 * Created by leo on 2018/7/28.
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        int start = 0,end = 0;
        for (int i = 0 ; i < s.length() ;i++) {
            int len1 = core(i,i,s);
            int len2 = core(i,i+1,s);
            System.out.println(len1+" "+len2);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    private int core(int l, int r, String s) {
        while (l >= 0 && r < s.length() &&
                s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("cbbd"));
    }
}

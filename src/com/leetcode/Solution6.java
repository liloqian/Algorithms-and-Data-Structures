package com.leetcode;

import java.util.HashMap;

/**
 * Created by leo on 2018/7/28.
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] strArr = new String[numRows];
        for (int i = 0 ; i < strArr.length ; i++) {
            strArr[i] = "";
        }
        boolean isDown = true;
        int count = 1;
        for (Character c : s.toCharArray()) {
            strArr[count - 1] += c;
            if (isDown) {
                count++;
                if (count > numRows) {
                    isDown = false;
                    count -= 2;
                }
            }else {
                count--;
                if (count <= 0) {
                    isDown = true;
                    count += 2;
                }
            }
        }
        String ret = "";
        for (String str : strArr) {
            ret += str;
        }
        return ret;
    }
// s = "PAYPALISHIRING", numRows = 4
    public static void main(String[] args) {
        System.out.println(new Solution6().convert("AB",1));
    }
}

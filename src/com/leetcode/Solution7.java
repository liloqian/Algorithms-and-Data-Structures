package com.leetcode;

import javax.sql.rowset.spi.SyncResolver;

/**
 * Created by leo on 2018/7/29.
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(1534236469));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isNeagtive = false;
        if (x < 0) {
            isNeagtive = true;
        }
        x = Math.abs(x);
        String retStr = core(x);
        int ret;
        try {
            ret = Integer.valueOf(retStr);
        }catch (Exception e){
            return 0;
        }
        if (isNeagtive) {
            return -ret;
        }
        return ret;
    }

    private String core(int x) {
        String origin = x + "";
        char[] originArr = origin.toCharArray();
        for (int i = 0 ; i < originArr.length/2 ; i++) {
            char temp = originArr[i];
            originArr[i] = originArr[originArr.length - i - 1];
            originArr[originArr.length - i - 1] = temp;
        }
        return new String(originArr);
    }
}

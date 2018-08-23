package com.leetcode;

/**
 * Created by leo on 2018/7/29.
 */
public class Solution8 {
    public int myAtoi(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        boolean valid = true;
        String validStr = "";
        for (char c : str.toCharArray()) {
            boolean isValid = isNumberChar(c);
            if (valid && c == ' ') {
                continue;
            }
            if (!valid && !isNumber(c)) {
                break;
            }
            if (valid && !isValid) {
                return 0;
            }
            if (c != ' ' && isValid) {
                validStr += c;
                valid = false;
            }
        }
        if (!isValidStr(validStr)) {
            return 0;
        }
        int ret ;
        try {
            ret = Integer.valueOf(validStr);
        }catch (Exception e) {
            if (validStr.startsWith("-")) {
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        return ret;
    }

    private boolean isValidStr(String s) {
        boolean isNumOk = false;
        int isFlagOk = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                isNumOk = true;
            }
            if (c == '+' || c == '-') {
                isFlagOk++;
            }
        }
        boolean flag = true;
        if (isFlagOk == 1) {
            flag = !(s.indexOf('-') > 0 || s.indexOf('+') > 0);
        }
        return isNumOk && flag && (isFlagOk <= 1);
    }

    private boolean isNumberChar(char c) {
        if ((c >= '0' && c <= '9') || c == '-' || c == '+') {
            return true;
        }
        return false;
    }

    public boolean isNumber (char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi( "-5-"));
    }
}

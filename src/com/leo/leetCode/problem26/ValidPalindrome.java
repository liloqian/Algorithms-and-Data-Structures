package com.leo.leetCode.problem26;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/b4dc0f1ee20448fca1f387fb1546f43f?tpId=46&tqId=29055&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @Date: Created in 16:48 2018/5/9
 **/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.equals("")){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isAlphanumeric(c)) {
                sb.append(c);
            }
        }
        String str = sb.toString();
        return core(str);
    }

    private boolean core(String str) {
        int sizeHalf = str.length() / 2;
        int sizeMax = str.length();
        String newLowerStr = str.toLowerCase();
        for (int i = 0 ; i < sizeHalf ; i++) {
            if (newLowerStr.charAt(i) != newLowerStr.charAt(sizeMax-1-i)) {
                return false;
            }
        }
        return true;
    }


    private boolean isAlphanumeric(char c){
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A"));
    }
}

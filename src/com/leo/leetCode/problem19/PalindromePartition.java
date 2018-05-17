package com.leo.leetCode.problem19;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/questionTerminal/1025ffc2939547e39e8a38a955de1dd3
 * @Date: Created in 11:04 2018/5/3
 **/
public class PalindromePartition {
    String str = null;
    public int minCut(String s) {
        this.str = s;
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int t = 0 ; t <= s.length() ;t++) {
            for (int i = 0 , j = t ; j < s.length() ; j++,i++) {
                dp[i][j] = compCut(i,j,dp);
            }
        }
        return dp[0][str.length()-1];
    }

    private int compCut(int i, int j,int[][] dp) {
        if (isPalindrome(i,j)) {
            return 0;
        }
        int min = str.length();
        for (int p = i ; p < j ;p++) {
            int a = dp[i][p];
            int b = dp[p+1][j];
            a = a + b + 1;
            min = min < a ? min : a;
        }
        return min;
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

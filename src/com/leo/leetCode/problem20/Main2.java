package com.leo.leetCode.problem20;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:13 2018/5/4
 **/
public class Main2 {
    private ArrayList<String > tempList = new ArrayList<>();
    private ArrayList<ArrayList<String>> retList = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String s) {
        dfs(s,0);
        return retList;
    }

    private void dfs(String s, int index) {
        if (index >= s.length()) {
            retList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index+1 ; i <= s.length() ; i++) {
            String temp = s.substring(index,i);
            if (isPalindrome(temp)) {
                tempList.add(temp);
                dfs(s,i);
                tempList.remove(temp);
            }
        }
    }


    private boolean isPalindrome(String tempStr) {
        int start = 0,end = tempStr.length() - 1;
        while (start < end) {
            if (tempStr.charAt(start) != tempStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Main2().partition("a"));
    }
}

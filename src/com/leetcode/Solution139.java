package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2018/8/7.
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean temp = false;
        for (int i = 0 ; i < wordDict.size() ; i++) {
            if (s.startsWith(wordDict.get(i))){
                temp = dealCore(wordDict, s.substring(wordDict.get(i).length(),s.length()));
            }
            if (temp) {
                return true;
            }
        }
        return false;
    }

    private boolean dealCore(List<String> wordDict, String substring) {
        if ("".equals(substring)) {
            return true;
        }
        for (int i = 0 ; i < wordDict.size() ; i++) {
            if (substring.startsWith(wordDict.get(i))) {
                if (dealCore(wordDict, substring.substring(wordDict.get(i).length(),substring.length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("dot");
        System.out.println(new Solution139().wordBreak("appledotappledotapple", list));
    }
}

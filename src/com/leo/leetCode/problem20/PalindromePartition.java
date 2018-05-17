package com.leo.leetCode.problem20;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description:https://www.nowcoder.com/practice/f983806a2ecb4106a17a365a642a9632?tpId=46&tqId=29049&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @Date: Created in 11:52 2018/5/4
 **/
public class PalindromePartition {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> retList = new ArrayList<>();

        corePartition(s,retList);

        return retList;
    }

    private void corePartition(String str, ArrayList<ArrayList<String>> retList) {
        for (int i = 1 ; i <= str.length() ; i++) {
            String tempStr = str.substring(0,i);
            if (isPalindrome(tempStr)) {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(tempStr);
                if (i == str.length()) {
                    retList.add(tempList);
                }else {
                    coreCorePartition(str.substring(i,str.length()),tempList,retList);
                }
            }
        }
    }

    private void coreCorePartition(String str, ArrayList<String> tempList, ArrayList<ArrayList<String>> retList) {
        for (int i = 1 ; i <= str.length() ; i++) {
            String tempStr = str.substring(0,i);
            if (isPalindrome(tempStr)) {
                ArrayList<String> tempLists = new ArrayList<>(tempList);
                tempLists.add(tempStr);
                if (i == str.length()) {
                    retList.add(tempLists);
                    return;
                }else {
                    coreCorePartition(str.substring(i,str.length()),tempLists,retList);
                }
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
        System.out.println(new PalindromePartition().partition("a"));
    }
}

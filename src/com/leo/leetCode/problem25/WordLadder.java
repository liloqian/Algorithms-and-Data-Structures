package com.leo.leetCode.problem25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/bd75ae43ff7148548eb4701550df2714?tpId=46&tqId=29054&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @Date: Created in 15:52 2018/5/9
 **/
public class WordLadder {

    // dfs
    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(start);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String str = queue.poll();
                size--;

                if (isDiffOne(str, end)) {
                    return res+1;
                }

                for (Iterator<String> it = dict.iterator(); it.hasNext(); ) {
                    String s = it.next();
                    if (isDiffOne(s, str)) {
                        queue.offer(s);
                        it.remove();
                    }
                }

            }

            res++;
        }
        return 0;
    }

    private boolean isDiffOne(String str, String end) {
        int diffNum = 0;
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) != end.charAt(i)) {
                diffNum++;
            }
        }
        return diffNum == 1;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        HashSet<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");


        System.out.println(new WordLadder().ladderLength(start,end,set));
    }
}

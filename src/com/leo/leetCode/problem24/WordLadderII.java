package com.leo.leetCode.problem24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 14:53 2018/5/9
 **/
public class WordLadderII {
    TreeSet<Integer> set = new TreeSet<>();

    int min = Integer.MAX_VALUE;
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int currentTransformation = 1;

        ArrayList<String> list = new ArrayList<>();
        list.add(start);
        core(start,end,dict,currentTransformation,list);

        if (set.size() == 0) {
            return 0;
        }
        return set.last();
    }

    private void core(String start, String end, HashSet<String> dict,int currentTransformation,ArrayList<String> list) {
        if (currentTransformation > min) {
            return;
        }
        if (diffOne(start,end) || start.equals(end)) {
            min = currentTransformation;
            set.add(currentTransformation+1);
//            System.out.println(list);
            return;
        }
        for (String str : dict) {
//            System.out.println(start+" "+str+" "+currentTransformation+" "+list);
            if (!list.contains(str) && diffOne(start,str)) {
                list.add(str);
                core(str,end,dict,currentTransformation+1,list);
                list.remove(str);
            }
        }
    }

    private boolean diffOne(String start, String str) {
        int diffNum = 0;
        for (int i = 0 ; i < start.length() ; i++) {
            if (start.charAt(i) != str.charAt(i)) {
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


        System.out.println(new WordLadderII().ladderLength(start,end,set));
    }
}

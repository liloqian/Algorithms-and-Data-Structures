package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by leo on 2018/8/5.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInputStr = scanner.nextLine();
        int personCount = Integer.valueOf(firstInputStr.split(" ")[0]);
        int aimPerson = Integer.valueOf(firstInputStr.split(" ")[1]);

        Map<Integer,HashSet<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < personCount; i++) {
            String temp = scanner.nextLine();
            HashSet<Integer> set = new HashSet<>();
            String[] tempArr = temp.split(" ");
            for (String s : tempArr) {
                set.add(Integer.valueOf(s));
            }
            map.put(i,set);
        }

        // begin deal
        HashSet<Integer> aimSet = map.get(aimPerson);
        Map<Integer, Integer> commonNumMap = new HashMap<>();
        int commonMax = 0;
        for (int index : map.keySet()) {
            if (index == aimPerson) {
                continue;
            }
            HashSet<Integer> tempSet = map.get(index);
            int commonNum = dealCore(aimSet, tempSet);
            if (commonMax < commonNum) {
                commonMax = commonNum;
            }
            commonNumMap.put(index,commonNum);
        }

        if (commonMax == 0) {
            System.out.println(-1);
            return;
        }

        for (int index : commonNumMap.keySet()) {
            if (commonNumMap.get(index) == commonMax) {
                System.out.println(index);
            }
        }
    }

    private static int dealCore(HashSet<Integer> aimSet, HashSet<Integer> tempSet) {
        int ret = 0;
        for (int i : aimSet) {
            if (tempSet.contains(i)){
                ret++;
            }
        }
        return ret;
    }
}

package com.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leo on 2018/8/11.
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i : nums) {
            if (map.get(i) != null && map.get(i)) {
                return true;
            }
            map.put(i,true);
        }
        return false;
    }
}

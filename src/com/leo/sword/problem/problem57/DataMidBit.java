package com.leo.sword.problem.problem57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 19:11 2018/3/25
 **/
public class DataMidBit {
    List<Integer> lists = new ArrayList<>();

    public void Insert(Integer num) {
        lists.add(num);
    }

    public Double GetMedian() {
        Collections.sort(lists);
        int size = lists.size();
        if (size % 2 == 1) {
            return lists.get(size/2)*1.0;
        }else {
            return (lists.get(size/2) + lists.get(size/2 - 1)) / 2.0;
        }
    }
}

package com.leo.sword.problem.problem59;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 19:44 2018/3/25
 **/
public class MoveWindowMax {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> retList = new ArrayList<>();
        if (num.length < size || size <= 0) {
            return retList;
        }
        ArrayList<Integer> datas = new ArrayList<>();
        for (Integer i : num) {
            datas.add(i);
        }
        int retSize = num.length - size;
        for (int i = 0 ; i <= retSize ; i++) {
            retList.add(getMaxCore(datas.subList(i,size+i)));
        }
        return retList;
    }

    private Integer getMaxCore(List<Integer> temp) {
        List<Integer> list = new ArrayList<>(temp);
        System.out.println(list);
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,2,6,2,5,1};
        new MoveWindowMax().maxInWindows(arr,3);
    }
}

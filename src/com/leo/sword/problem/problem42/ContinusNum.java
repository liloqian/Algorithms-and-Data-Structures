package com.leo.sword.problem.problem42;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: qian
 * @Description: 还有条件未考虑 ，86%通过率
 * @Date: Created in 16:57 2018/3/23
 **/
public class ContinusNum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<>();


        for (int i = 3 ; i < sum/2 ; i += 2){
            if (sum % i == 0) {
                core(sum, i, retList);
            }
        }
        Collections.reverse(retList);
        int tempInt = sum;
        if (tempInt % 2 == 1 && tempInt > 1){
            ArrayList temp = new ArrayList();
            temp.add(tempInt/2);
            temp.add(tempInt/2 + 1);
            retList.add(temp);
        }
        return retList;
    }

    private void core(int sum, int i, ArrayList<ArrayList<Integer>> retList) {
        int mid = sum / i;
        int half = i / 2;
        if (mid-half < 0){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int temp = mid - half ;temp <= mid + half ;temp++) {
            list.add(temp);
        }
        retList.add(list);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ContinusNum().FindContinuousSequence(100);
        for (ArrayList<Integer> temp : list) {
            System.out.println(temp);
        }
    }
}

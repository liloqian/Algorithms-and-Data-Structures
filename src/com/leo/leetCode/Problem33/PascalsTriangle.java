package com.leo.leetCode.Problem33;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/f3f8f0f058b347ba8245cc90d0049d92?tpId=46&tqId=29062&tPage=2&rp=2&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * @Date: Created in 22:23 2018/5/9
 **/
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if (numRows <= 0) {
            return listAll;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0 ; i < numRows  ; i++) {
            for (int j = i - 1 ; j > 0 ; j--) {
                temp.set(j,temp.get(j)+temp.get(j-1));
            }
            temp.add(1);
            listAll.add(new ArrayList<>(temp));
        }

        return listAll;
    }

}

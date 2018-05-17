package com.leo.leetCode.Problem32;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/a60ee4a1c8a04c3a93f1de3cf9c16f19?tpId=46&tqId=29061&tPage=2&rp=2&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * @Date: Created in 21:58 2018/5/9
 **/
public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        if (rowIndex < 0) {
            return row;
        }
        for (int i = 0 ; i < rowIndex + 1 ; i++) {
            for (int j = i - 1; j > 0 ;j--) {
                row.set(j,row.get(j)+row.get(j-1));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(1));
    }
}

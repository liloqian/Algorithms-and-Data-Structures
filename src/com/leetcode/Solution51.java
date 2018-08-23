package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2018/8/13.
 */
public class Solution51 {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        nQueue(n, 0, new int[n],ret);
        return ret;
    }

    private void nQueue(int n, int row, int[] temp, List<List<String>> ret) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0 ; i < n ; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0 ; j < n ; j++) {
                    if (temp[i] == j) {
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            ret.add(list);
            return;
        }
        for (int i = 0 ;i < n ; i++) {
            temp[row] = i;
            if (checkOk(row, temp)) {
                nQueue(n, row+ 1, temp,ret);
            }
        }
    }

    private boolean checkOk(int row, int[] temp) {
        for (int i = 0 ; i < row ;i++) {
            if (temp[row] == temp[i] ||
                    Math.abs(temp[row] - temp[i]) == row - i) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<String>> ret = new Solution51().solveNQueens(1);
        for (List<String> list : ret) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("\n");
        }
    }

}

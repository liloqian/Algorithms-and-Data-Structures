package com.leo.leetCode.problem31;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:32 2018/5/9
 **/
public class Triangle {
    int minPathSum = Integer.MAX_VALUE;
    ArrayList<Integer> list = new ArrayList<>();
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int current = triangle.get(0).get(0);
        coreMinTotal(1,0,triangle,current);
        return minPathSum;
    }

    private void coreMinTotal(int row, int index, ArrayList<ArrayList<Integer>> triangle, int current) {
        ArrayList<Integer> currentRow = triangle.get(row);
        if (row+1 == triangle.size()) {
            current += Math.min(currentRow.get(index),currentRow.get(index+1));
            list.add(current);
            if (minPathSum > current) {
                minPathSum = current;
            }
            return;
        }
        coreMinTotal(row+1,index,triangle,current+currentRow.get(index));
        coreMinTotal(row+1,index+1,triangle,current+currentRow.get(index+1));
    }

    public static void main(String[] args) {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(-1);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(3);

        ArrayList<Integer> three = new ArrayList<>();
        three.add(1);
        three.add(-1);
        three.add(-3);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(one);
        lists.add(two);
        lists.add(three);

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(lists));
        System.out.println(triangle.list);

    }
}

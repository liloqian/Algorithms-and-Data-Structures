package com.leo.sword.problem.problem43;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S
 * ，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @Date: Created in 17:58 2018/3/23
 **/
public class SumEqualS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0 ; i < array.length-1; i++) {
            int temp = sum - array[i];
            if (temp < 0) {
                break;
            }
            for (int j = i + 1 ; j < array.length && array[j] <= temp; j++) {
                if (array[j] == temp) {
                    list.add(new Point(array[i], array[j]));
                    break;
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        if (list.size() <= 0) {
            return ret;
        }

        int indexRet = 0;
        int min = list.get(0).x * list.get(0).y;
        for (int i = 1 ; i < list.size(); i++) {
            int temp = list.get(i).x * list.get(i).y;
            if (temp < min) {
                min = temp;
                indexRet = i;
            }
        }


        ret.add(list.get(indexRet).x);
        ret.add(list.get(indexRet).y);

        return ret;
    }


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


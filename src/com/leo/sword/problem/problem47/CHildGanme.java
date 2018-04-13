package com.leo.sword.problem.problem47;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:25 2018/3/24
 **/
public class CHildGanme {
    public int LastRemaining_Solution(int n, int m) {
        if (m <= 0 || n <= 0){
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            list.add(i);
        }

        int startFlag = 0;
        while (true) {
            if (list.size() == 1) {
                return list.get(0);
            }
            int currentIndex = (startFlag + m) % list.size();
            if (currentIndex > 0) {
                System.out.println(list.remove(currentIndex-1));
                startFlag = currentIndex-1;
            }else {
                System.out.println(list.remove(list.size()-1));
                startFlag = 0;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new CHildGanme().LastRemaining_Solution(5,3));
    }
}

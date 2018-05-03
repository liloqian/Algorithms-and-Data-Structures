package com.leo.leetCode.problem17;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qian
 * @Description: There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * @Date: Created in 20:22 2018/4/1
 **/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            }else {
                return -1;
            }
        }
        int[] diff = new int[gas.length];
        for (int i = 0 ; i < gas.length ; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int temp ;
        for (int i = 0 ; i < diff.length ;i++) {
            ArrayList<Integer> list = new ArrayList<>();
            temp = 0;
            for (int j = i ; j < diff.length ;j++) {
                temp += diff[j];
                list.add(temp);
            }
            for (int j = 0 ; j < i; j++) {
                temp += diff[j];
                list.add(temp);
            }
            Collections.sort(list);
            if (list.get(0) >= 0) {
                return i;
            }
        }
        return -1;
    }
}

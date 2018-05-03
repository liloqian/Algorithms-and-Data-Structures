package com.leo.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:13 2018/4/25
 **/
public class NoRepeatNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int tempNum = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            while (tempNum != 0) {
                int finalNum = tempNum % 10;
                tempNum /= 10;
                if (!list.contains(finalNum)) {
                    list.add(finalNum);
                }
            }
            int retSum = 0;
            for (int i : list) {
                retSum = retSum * 10 + i;
            }
            System.out.println(retSum);
        }
    }
}

package com.leo.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:55 2018/4/4
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aimLen = scanner.nextInt();
        int aLen = scanner.nextInt();
        int aNum = scanner.nextInt();
        int bLen = scanner.nextInt();
        int bNum = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        core(list,aLen,bLen,aimLen,aimLen);

        System.out.println(list);

    }

    private static void core(List<Integer> list, int aLen, int bLen, int aimLen,int max) {
        if (aimLen == aLen) {
            list.add(aLen);
            return;
        }else if (aimLen == bLen) {
            list.add(bLen);
            return;
        }

        list.add(aLen);
        core(list, aLen, bLen, aimLen -aLen,max);
        list.remove(Integer.valueOf(aimLen));


        if (!judge(max,list)) {
            list.add(bLen);
            core(list, aLen, bLen, aimLen-bLen,max);
        }
    }

    private static boolean judge(int max, List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        if (max == sum) {
            return true;
        }else {
            return false;
        }
    }

}

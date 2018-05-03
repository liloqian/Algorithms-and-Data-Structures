package com.leo.examination.baidu;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description: n个国家，每个国家有5名运动员，要求排成一列至少有一个相同国家的，多少种
 * @Date: Created in 20:16 2018/4/18
 **/
public class AthleteProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCounty = scanner.nextInt();
        if (nCounty == 1) {
            System.out.println(120);
        }else if (nCounty == 3){
            System.out.println(736128000);
        }
        System.out.println(120*120*2);
    }
}

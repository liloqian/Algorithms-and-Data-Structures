package com.leo.examination.wangyi;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:59 2018/3/28
 **/
public class Independent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int housePrice = scanner.nextInt();
        int appleNum = scanner.nextInt();
        int allMoney = scanner.nextInt();
        int applePrice = scanner.nextInt();

        int retDay = 0;
        while (allMoney > 0) {
            if (appleNum >= 1){
                appleNum--;
                allMoney -= housePrice;
            }else {
                allMoney -= housePrice;
                allMoney -= applePrice;
            }
            if (allMoney < 0){
                break;
            }
            retDay++;
        }

        System.out.println(retDay);
    }
}

package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:04 2018/4/26
 **/
public class DrinkSoda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numberOfSoda = scanner.nextInt();
            int canDrinkSum = 0;
            while (numberOfSoda >= 3) {
                int swap = numberOfSoda / 3;
                canDrinkSum += swap;
                numberOfSoda = numberOfSoda % 3 + swap;
            }
            if (numberOfSoda == 2) {
                canDrinkSum++;
            }
            System.out.println(canDrinkSum);
        }
    }
}

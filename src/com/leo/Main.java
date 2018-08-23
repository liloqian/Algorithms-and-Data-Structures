package com.leo;

import java.util.Scanner;

/**
 * Created by leo on 2018/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // deal
        for (int i = 2 ; i <= input.length()/2 ; i++) {
            if (dealCore(input, i)) {
                System.out.println(input.substring(0, i) + " "+ i);
                return;
            }
        }
    }

    private static boolean dealCore(String input, int len) {
        if (input.length() % len != 0) {
            return false;
        }

        String origin = input.substring(0, len);
        for (int i = 1 ; i < input.length() / len ; i++) {
            if (!origin.equals(input.substring(i * len, i * len + len))) {
//                System.out.println(origin+"  "+input.substring(i*2, i * 2 + len));
                return false;
            }
        }
        return true;
    }
}

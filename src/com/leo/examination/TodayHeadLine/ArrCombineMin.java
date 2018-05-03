package com.leo.examination.TodayHeadLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description: 今日头条实习第二波招聘,输入数组全是素数递增，m<n，给出第k个m/n小的m n
 * @Date: Created in 10:29 2018/4/15
 **/
public class ArrCombineMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        for (int i = 0 ; i < Integer.valueOf(time) ; i++) {
            String[] temp = scanner.nextLine().split(" ");
            int aim = Integer.valueOf(temp[0]);
            int[] arr = new int[temp.length-1];
            for (int j = 0 ; j < arr.length; j++) {
                arr[j] = Integer.valueOf(temp[j+1]);
            }

            // deal
            List<Point> list = new ArrayList<>();
            for (int j = 0 ; j < arr.length ; j++) {
                for (int n = j + 1 ; n < arr.length ;n++) {
                    Point p = new Point(arr[j], arr[n]);
                    p.rate = 1.0d * arr[j] / arr[n];
                    list.add(p);
                }
            }
            Collections.sort(list);
            System.out.println(list.get(aim-1).m + " "+list.get(aim-1).n);
        }
    }
    static class Point implements Comparable<Point>{
        int m;
        int n;
        double rate;

        public Point(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public int compareTo(Point o) {
            if (o.rate < this.rate) {
                return 1;
            }else if (o.rate > this.rate) {
                return -1;
            }else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Point{" +
                    "m=" + m +
                    ", n=" + n +
                    ", rate=" + rate +
                    '}';
        }
    }
}



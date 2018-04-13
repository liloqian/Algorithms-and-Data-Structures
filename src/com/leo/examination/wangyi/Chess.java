package com.leo.examination.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/question/next?pid=6291726&qid=112727&tid=14650201
 * @Date: Created in 9:14 2018/3/29
 **/
public class Chess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chessCount = scanner.nextInt();
        Point[] points = new Point[chessCount];
        for (int i = 0 ; i < chessCount;i++) {
            points[i] = new Point();
            points[i].x = scanner.nextInt();
        }
        for (int i = 0 ; i < chessCount; i++) {
            points[i].y = scanner.nextInt();
        }

        // 处理
        core(points);
    }

    private static void core(Point[] points) {
        int[] ret = new int[points.length];
        ret[0] = 0;

        ArrayList<Integer>[] arrayLists = new ArrayList[points.length];
        for (int i = 0 ; i < ret.length ;i++) {
            arrayLists[i] = calculate(points,i);
            System.out.println(arrayLists[i]);
            Collections.sort(arrayLists[i]);
        }

        for (int i = 1 ; i < ret.length ; i++) {
            int temp = subMin(arrayLists[0],i);
            for (int j = 1 ; j < arrayLists.length ;j++) {
                temp = Math.min(temp, subMin(arrayLists[j],i));
            }
            ret[i] = temp;
        }

        for (int i = 0 ; i < ret.length - 1 ; i++) {
            System.out.print(ret[i]+" ");
        }
        System.out.print(ret[ret.length-1]);
    }

    private static int subMin(ArrayList<Integer> arrayList, int range) {
        int ret = 0;
        for (int i = 0 ; i < range ;i++) {
            ret += arrayList.get(i);
        }
        return ret;
    }

    private static ArrayList calculate(Point[] points, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < points.length ;i++) {
            if (i != index) {
                list.add(lenCalculate(points,index,i));
            }
        }
        return list;
    }

    private static Integer lenCalculate(Point[] points, int i, int index) {
        return Math.abs(points[i].x - points[index].x) + Math.abs(points[i].y - points[index].y);
    }

    static class Point{
        int x;
        int y;
    }
}

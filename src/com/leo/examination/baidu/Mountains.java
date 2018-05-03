package com.leo.examination.baidu;

import java.util.*;

/**
 * @Author: qian
 * @Description: 爬山可以到达的最高点，每次只能选择向上爬
 * @Date: Created in 18:52 2018/4/18
 **/
public class Mountains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int startX = scanner.nextInt() - 1;
        int startY = scanner.nextInt() - 1;
        int[][] arr = new int[row][column];
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < column ;j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        boolean[][] flag = new boolean[row][column];
        HashSet<Integer> set = new HashSet<>();
        List<Point> list = new ArrayList<>();

        Point startPoint = new Point(startX, startY);
        set.add(arr[startX][startY]);
        list.add(startPoint);

        while (list.size() > 0) {
            Point temp = list.remove(0);
            if (flag[temp.x][temp.y]) {
                continue;
            }
            flag[temp.x][temp.y] = true;
            if (temp.x + 1 < row && !flag[temp.x+1][temp.y]) {
                if (arr[temp.x+1][temp.y] > arr[temp.x][temp.y]) {
                    set.add(arr[temp.x+1][temp.y]);
                    list.add(new Point(temp.x+1,temp.y));
                }
            }
            if (temp.x - 1 > 0 && !flag[temp.x-1][temp.y]) {
                if (arr[temp.x-1][temp.y] > arr[temp.x][temp.y]){
                    set.add(arr[temp.x-1][temp.y]);
                    list.add(new Point(temp.x-1,temp.y));
                }
            }
            if (temp.y - 1 > 0 && !flag[temp.x][temp.y-1]) {
                if (arr[temp.x][temp.y-1] > arr[temp.x][temp.y]) {
                    set.add(arr[temp.x][temp.y-1]);
                    list.add(new Point(temp.x,temp.y-1));
                }
            }
            if (temp.y + 1 < column && !flag[temp.x][temp.y+1]) {
                if (arr[temp.x][temp.y+1] > arr[temp.x][temp.y]) {
                    set.add(arr[temp.x][temp.y+1]);
                    list.add(new Point(temp.x,temp.y+1));
                }
            }
        }

        List<Integer> ret = new ArrayList<>(set);
        Collections.sort(ret);
        System.out.println(ret.get(ret.size()-1));
    }

    static class Point{
        int x;
        int y;

        public Point(){}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

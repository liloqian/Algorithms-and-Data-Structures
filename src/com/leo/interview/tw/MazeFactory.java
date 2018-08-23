package com.leo.interview.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leo on 2018/7/27.
 */
public class MazeFactory {

    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        String gridSize = scanner.nextLine();
        String addPosition = scanner.nextLine();

        render(gridSize, addPosition);
    }

    private static void render(String gridSize, String addPosition) {
        // 起始标注点
        List<Point> initPoint = new ArrayList<>();
        String[] gridSizeArr = gridSize.split(" ");
        int originRow = -1, originColumn = -1;
        try {
            originRow = Integer.valueOf(gridSizeArr[0]);
            originColumn = Integer.valueOf(gridSizeArr[1]);
        }catch (Exception e) {
            System.out.println("invalid number format.");
            return;
        }
        for (int i = 0 ; i < originRow ; i++) {
            for (int j = 0 ; j < originColumn ;j++) {
                initPoint.add(new Point(i * 2 + 1, j * 2 + 1));
            }
        }
        // 联通标注点
        List<Point> edgePoint = new ArrayList<>();
        String[] edgePointArr = addPosition.split(";");
        int firstX = -1 , firstY = -1, secondX = -1, secondY = -1;
        for (String str : edgePointArr) {
            String[] ponitArr = str.split(" ");
            try {
                firstX = Integer.valueOf(ponitArr[0].split(",")[0]);
                firstY = Integer.valueOf(ponitArr[0].split(",")[1]);
                secondX = Integer.valueOf(ponitArr[1].split(",")[0]);
                secondY = Integer.valueOf(ponitArr[1].split(",")[1]);
            }catch (Exception e) {
                System.out.println("invalid number format.");
                return;
            }
            if (checkNumRange(firstX, secondX, originRow) ||
                    checkNumRange(firstY, secondY, originColumn)
                    ) {
                System.out.println("Number out of range.");
                return;
            }
            int diffX = Math.abs(firstX - secondX);
            int diffY = Math.abs(firstY - secondY);
            if (diffX == 0 && diffY == 1) {
                edgePoint.add(new Point(firstX * 2 + 1 ,Math.min(firstY, secondY) * 2+ 2));
            }else if (diffX == 1 && diffY == 0){
                edgePoint.add(new Point(Math.min(firstX, secondX) * 2 + 2 ,firstY * 2 + 1));
            }else {
                System.out.println("”Maze format error.");
                return;
            }
        }
        // 填充返回结果
        boolean[][] retGrid = new boolean[originRow * 2 + 1][originColumn * 2 + 1];
        for (Point p : initPoint) {
            retGrid[p.x][p.y] = true;
        }
        for (Point p : edgePoint) {
            retGrid[p.x][p.y] = true;
        }
        printRetGrid(retGrid);
    }

    private static void printRetGrid(boolean[][] retGrid) {
        String[] showStr = new String[]{"[R]","[W]"};
        for (int i = 0 ; i < retGrid.length ; i++) {
            for (int j = 0 ; j < retGrid[0].length ; j++) {
                String str = null;
                if (retGrid[i][j]) {
                    str = showStr[0];
                } else {
                    str = showStr[1];
                }
                if (j != retGrid[0].length - 1) {
                    System.out.print(str+" " );
                } else {
                    System.out.print(str+"\n" );
                }
            }
        }
    }

    private static boolean checkNumRange(int first, int second, int origin) {
        if (first < 0 || first >= origin) {
            return true;
        }
        if (second < 0 || second >= origin) {
            return true;
        }
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
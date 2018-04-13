package com.leo.sword.recall;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:10 2018/3/19
 **/
public class Robot {
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0|| threshold < 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        int retCount = movingCountCore(threshold, rows, cols, 0, 0, visited);

        return retCount;
    }

    private static int movingCountCore(int threshold, int rows, int cols, int nowRow, int nowCols, boolean[] visited) {
        int count = 0;
        if (nowCols >= 0 && nowCols < cols && nowRow >= 0 && nowRow < rows
                && checkCondition(nowRow, nowCols, threshold)
                && !visited[nowRow * cols + nowCols]) {

            visited[nowRow * cols + nowCols] = true;
            count = 1 + movingCountCore(threshold, rows, cols, nowRow, nowCols - 1, visited)
                    + movingCountCore(threshold, rows, cols, nowRow, nowCols + 1, visited)
                    + movingCountCore(threshold, rows, cols, nowRow - 1, nowCols, visited)
                    + movingCountCore(threshold, rows, cols, nowRow + 1, nowCols, visited);
        }
        return count;
    }

    private static boolean checkCondition(int row, int col, int threshold) {
        if (getNumberSum(row) + getNumberSum(col) <= threshold) {
            return true;
        }else {
            return false;
        }
    }

    private static int getNumberSum(int x){
        int sum = 0;
        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }
}

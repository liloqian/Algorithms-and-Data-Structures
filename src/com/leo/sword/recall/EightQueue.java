package com.leo.sword.recall;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 9:26 2018/3/30
 **/
public class EightQueue {
    private static final int QueueNum = 8;
    private static int count = 0;

    public static void main(String[] args) {
        int[][] chess = new int[QueueNum][QueueNum];

        queueCore(chess, 0);

        System.out.println("共有   "+count);
    }

    private static void queueCore(int[][] chess, int row) {
        if (row == QueueNum) {
            count++;
            System.out.println("第"+count+"解是:  ");
            for (int i = 0 ; i < QueueNum ; i++) {
                for (int j = 0 ; j < QueueNum ; j++) {
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

//        int[][] tempChess = chess.clone();

        // 按列循环
        for (int i = 0 ; i < QueueNum ; i++) {
            for (int j = 0 ; j < QueueNum ; j++) {
                chess[row][j] = 0;
            }
            chess[row][i] = 1;

            if (isSafe(chess, row, i)) {
                queueCore(chess, row+1);
            }
        }
    }

    private static boolean isSafe(int[][] chess, int row, int col) {
        int index = 1;
        while (row - index >= 0) {
            if (chess[row-index][col] == 1) {
                return false;
            }
            if (col - index >= 0 && chess[row-index][col-index] == 1) {
                return false;
            }
            if (col + index < QueueNum && chess[row-index][col+index] == 1) {
                return false;
            }
            index++;
        }
        return true;
    }
}

package work_begin.pingduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by leo on 2018/7/22.
 */
public class One {
    private static ArrayList<Integer> allRet = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column =  scanner.nextInt();
        int[][] data = new int[row][column];
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < column ; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1 ; i < row - 1 ; i++) {
            for (int j = 1 ; j < column - 1 ; j++) {
                dealCore(data, i, j);
            }
        }
        Collections.sort(allRet);
        System.out.println(allRet.get(allRet.size()-1));
    }

    private static void dealCore(int[][] data, int startR, int startC) {
        boolean[][] flag = new boolean[data.length][data[0].length];

        if (data[startR][startC-1] < data[startR][startC]) {
            flag[startR][startC-1] = true;
            flag[startR][startC] = true;
            int diff = data[startR][startC] - data[startR][startC-1];
            dealCoreCore(data,flag, startR, startC - 1, diff);
        }
        if (data[startR][startC+1] < data[startR][startC]) {

        }
        if (data[startR-1][startC] < data[startR][startC]) {

        }
        if (data[startR+1][startC] < data[startC][startC]) {

        }
    }

    private static void dealCoreCore(int[][] data, boolean[][] flag, int nowR, int nowC, int nowDiff) {
        if ((nowC == 0 && nowR == 0) ||
                (nowC == 0 && nowR == data.length - 1)||
                (nowC == data[0].length -  1&& nowR == 0) ||
                nowC == data[0].length - 1 && nowR == data.length - 1) {
            allRet.add(nowDiff);
        }
        if (!flag[nowR][nowC-1] && data[nowR][nowC-1] < data[nowR][nowC]) {

        }
    }
}

package work_begin.DJ;

import java.util.Scanner;

/**
 * Created by leo on 2018/7/8.
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] bArr = new int[n][m];
        int[][] aArr = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                bArr[i][j] = scanner.nextInt();
                aArr[i][j] = 1;
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (bArr[i][j] == 0) {
                    dealWith(i,j,aArr);
                }
            }
        }

        int[][] bNewArr = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ;j++) {
                bNewArr[i][j] = dealAtoB(i,j,aArr);
            }
        }

        for (int i  = 0 ; i < n ; i++) {
            for (int j = 0 ;j < m ; j++) {
                if (bNewArr[i][j] != bArr[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    private static int dealAtoB(int row, int column, int[][] aArr) {
        for (int i = 0 ; i < aArr.length ; i++) {
            if (aArr[i][column] == 1) {
                return 1;
            }
        }
        for (int j = 0 ; j < aArr[0].length ; j++) {
            if (aArr[row][j] == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static void dealWith(int row, int column, int[][] aArr) {
        for (int j = 0; j < aArr[0].length ; j++) {
            aArr[row][j] = 0;
        }
        for (int i = 0 ; i < aArr.length ; i++) {
            aArr[i][column] = 0;
        }
    }
}

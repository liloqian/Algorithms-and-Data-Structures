package com.leo.leetCode.problem21;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/c159db5028034aa595043a1a220a62dd?tpId=46&tqId=29050&tPage=2&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * @Date: Created in 15:30 2018/5/4 X
 **/
public class SurroundedRegions {
    /**
     * 遍历四条外边中的O，与四条外边相连的都变为O（不变）
     * 剩余的全部变为x
     * */
    private int row = 0;
    private int column = 0;
    private boolean[][] flag = null;
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }

        row = board.length;
        column = board[0].length;
        flag = new boolean[row][column];
        for (int i = 0 ; i < column ; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        for (int i = 0 ; i < row ; i++) {
            dfs(board,i,0);
            dfs(board,i,column-1);
        }
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < column ;j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'O') {
            flag[x][y] = true;
            if (x > 1 && !flag[x-1][y]) {
                dfs(board,x-1,y);
            }
            if (x < row - 1 && !flag[x+1][y]) {
                dfs(board,x+1,y);
            }
            if (y > 1 && !flag[x][y-1]) {
                dfs(board,x,y-1);
            }
            if (y < column - 1 && !flag[x][y+1]) {
                dfs(board,x,y+1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] arr =new char[3][3];
        arr[0][0] = 'X';
        arr[0][1] = 'X';
        arr[0][2] = 'X';

        arr[1][0] = 'X';
        arr[1][1] = 'O';
        arr[1][2] = 'X';

        arr[2][0] = 'X';
        arr[2][1] = 'X';
        arr[2][2] = 'X';
        printTwoArr(arr);
        new SurroundedRegions().solve(arr);
        printTwoArr(arr);

    }

    private static void printTwoArr(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr[0].length ;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
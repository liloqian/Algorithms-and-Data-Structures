package com.leo.sword.recall;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:25 2018/3/30
 **/
public class MazeProblem {

    public static final int MAZE_SIZE = 15;
    int[][] maze;
    Stack<Position> stack;
    boolean[][] flag;
    int row;
    int col;

    public MazeProblem() {
        maze = new int[15][15];
        stack = new Stack<>();
        flag = new boolean[MAZE_SIZE][MAZE_SIZE];
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入迷宫的行数");
        row = scanner.nextInt();
        System.out.println("请输入迷宫的列数");
        col = scanner.nextInt();
        System.out.println("请输入" + row + "行" + col + "列的迷宫");
        int temp = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                temp = scanner.nextInt();
                maze[i][j] = temp;
                flag[i][j] = false;
            }
        }
    }

    public void findPath() {
        int temp[][] = new int[row+2][col+2];
        for (int i = 0 ; i < row + 2 ;i++) {
            for (int j = 0 ; j < col + 2 ;j++) {
                temp[0][j] = 1;
                temp[row+1][j] = 1;
                temp[i][0] = 1;
                temp[i][col+1] = 1;
            }
        }

        for (int i = 0 ; i < row ;i++) {
            for (int j = 0 ; j < col ;j++) {
                temp[i+1][j+1] = maze[i][j];
            }
        }

        // core
        int i = 1;
        int j = 1;
        flag[i][j] = true;
        stack.push(new Position(i,j));
        while (!stack.empty() && !((i == row) && (j == col)) ) {
            // 右
            if (temp[i][j+1] == 0 && !flag[i][j+1]){
                flag[i][j+1] = true;
                stack.push(new Position(i,j+1));
                j++;
            }else if (temp[i][j-1] == 0 && !flag[i][j-1]) {
                flag[i][j-1] = true;
                stack.push(new Position(i,j-1));
                j--;
            }else if (temp[i+1][j] == 0 && !flag[i+1][j] ) {
                flag[i+1][j] = true;
                stack.push(new Position(i+1,j));
                i++;
            }else if (temp[i-1][j] == 0 && !flag[i-1][j] ) {
                flag[i-1][j] = true;
                stack.push(new Position(i-1,j));
                i--;
            }else {
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                i = stack.peek().col;
                j = stack.peek().row;
            }
        }

        if (stack.empty()) {
            System.out.println("没有路径");
        }else {
            System.out.println("有路径");
            while (!stack.empty()) {
                System.out.println(stack.pop());
            }
        }

    }

    public static void main(String[] args) {
        MazeProblem maze = new MazeProblem();
        maze.init();
        maze.findPath();
    }
}

class Position {
    int row;
    int col;

    public Position() {
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

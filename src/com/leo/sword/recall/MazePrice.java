package com.leo.sword.recall;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:26 2018/3/30
 **/
public class MazePrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if(s.equals("0 0 0")) break;
            String[] split = s.trim().split("\\s+");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int t = Integer.parseInt(split[2]);
            char[][] arr = new char[m][n];
            Node start = new Node();
            Node end = new Node();
            for (int i = 0; i < m; i ++ ) {
                String s1 = scanner.nextLine();
                for (int j = 0; j < n; j ++ ) {
                    arr[i][j] = s1.charAt(j);
                    if(arr[i][j] == 'S') {
                        start.x = i;
                        start.y = j;
                    }
                    if(arr[i][j] == 'P') {
                        end.x = i;
                        end.y = j;
                    }
                }
            }
            // deal core
            bfs(arr,m ,n, t, start, end);

        }
        return;
    }

    private static void bfs(char[][] arrs, int row, int col, int days, Node start, Node end) {
        int[][] direction = {{0, 1}, {0, - 1}, {1, 0}, { - 1, 0}};
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        visited[start.x][start.y] = true;
        queue.add(start);
        boolean isFinished = false;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.x == end.x && curr.y == end.y && curr.time <= days) {
                isFinished = true;
                break;
            }
            for (int i = 0 ; i < 4 ;i++) {
                Node next = new Node();
                next.x = curr.x + direction[i][0];
                next.y = curr.y + direction[i][1];
                next.time = curr.time+1;
                if (next.x >= 0 && next.x < row && next.y >= 0 && next.y < col
                    && !visited[next.x][next.y] && arrs[next.x][next.y] != '*') {
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
        if (isFinished) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    static class Node {
        int x;
        int y;
        int time;
    }
}

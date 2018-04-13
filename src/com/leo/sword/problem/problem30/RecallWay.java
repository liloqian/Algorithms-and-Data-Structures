package com.leo.sword.problem.problem30;

/**
 * @Author: qian
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @Date: Created in 20:30 2018/3/19
 **/
public class RecallWay {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 参数判断
        if (matrix == null || str == null || rows < 1 || cols < 1) {
            return false;
        }

        boolean[] visited = new boolean[matrix.length];
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, i, j, str, pathLength, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols,
                                       int nowRow, int nowCol, char[] str, int len, boolean[] visited){
        if (len == str.length) {
            return true;
        }

        boolean hasPath = false;

        if (nowRow >= 0 && nowRow < rows && nowCol >= 0 && nowCol < cols
                && matrix[nowCol + nowRow * cols] == str[len]
                && !visited[nowCol + nowRow * cols]){
            len++;
            visited[nowCol + nowRow * cols] = true;
            hasPath = hasPathCore(matrix, rows, cols, nowRow, nowCol-1, str, len, visited)
                    || hasPathCore(matrix, rows, cols, nowRow, nowCol+1, str, len, visited)
                    || hasPathCore(matrix, rows, cols, nowRow-1, nowCol, str, len, visited)
                    || hasPathCore(matrix, rows, cols, nowRow+1, nowCol, str, len, visited);

            if (!hasPath) {
                len--;
                visited[nowCol + nowRow * cols] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] aim = "ABCCED".toCharArray();

        System.out.println(hasPath(matrix,3,4,aim));
    }
}

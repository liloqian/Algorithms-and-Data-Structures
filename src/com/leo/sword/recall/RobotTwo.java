package com.leo.sword.recall;

/**
 * @Author: qian
 * @Description： https://www.nowcoder.com/practice/b3ae8b9782af4cf29253afb2f6d6907d?tpId=8&&tqId=11034&rp=1&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
 * @Date: Created in 16:46 2018/3/30
 **/
public class RobotTwo {
    //DP
    public int countWaysTwo(int[][] map,int x,int y){
        int[][] dp = new int[x][y];
        for (int i = 0 ; i < x ;i++) {
            for (int j = 0 ; j < y ; j++) {
                if (map[i][j] != 1){
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j-1];
                }else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
        return dp[x-1][y-1];
    }

    // 回溯法 （超时了）
    public int countWays(int[][] map, int x, int y) {

        return core(map, x, y, 0, 0);

    }

    private int core(int[][] map, int row, int col, int currentX, int currentY) {
        int ret = 0;
        if (map[currentX][currentY] != 1){
            return 0;
        }
        if ((currentX == (row - 1)) && (currentY == (col - 1)) ) {
            return 1;
        }

        if (currentX + 1 < row) {
            ret += core(map, row, col, currentX + 1, currentY);
            ret = ret % 1000000007;
        }
        if (currentY + 1 < col) {
            ret += core(map, row, col, currentX, currentY + 1);
            ret = ret % 1000000007;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[1][2] = 1;
        arr[2][0] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;

       int ret =  new RobotTwo().countWays(arr,3,3);
       System.out.println(ret);
       ret =  new RobotTwo().countWaysTwo(arr,3,3);
       System.out.println(ret);
    }
}

package com.leo.interview;

/**
 * @Author: qian
 * @Description: 二维多重背包转换成二维01背包解决
 * @Date: Created in 15:32 2018/3/15
 **/
public class BagProblem {
    public static final int MAX = 99;
    private static void deal(int count,int cMax,int dMax, int[] c,int[] d,int[] v){
        System.out.println("开始处理...");
        int[][][] dp = new int[count+1][cMax+1][dMax+1];

        for(int i = 1; i <count + 1 ;i++){
            for(int j = 1 ; j <= cMax; j++) {
                for (int k = 1 ; k <= dMax ;k++) {
                    if(c[i] <= j && d[i] <= k){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-c[i]][k-d[i]]+v[i]);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        System.out.println("最优结果是: "+dp[count][cMax][dMax]);
        int[] x = new int[MAX];
        for ( int i = count ;i > 1 ;i--){
            if (dp[i][cMax][dMax] == dp[i-1][cMax][dMax]) {
                x[i] = 0;
            }else {
                x[i] = 1;
                cMax -= c[i];
                dMax -= d[i];
            }
        }
        x[1] = dp[1][cMax][dMax] == 0 ? 0 : 1;
        for (int i = 1; i < count+1;i++ ){
            if(x[i] == 1){
                System.out.println("第 "+i+" 个物品 "+c[i]+"  "+d[i]+" "+v[i]+" ");
            }
        }

    }

    public static void main(String[] args) {
        int nCount , cMax, dMax;
        nCount = 5; //物品个数
        cMax = 8;   //容量 约束1
        dMax = 7;   //体积 约束2
        int[] c = new int[MAX];
        int[] d = new int[MAX];
        int[] v = new int[MAX];

        c[1] = 3;
        c[2] = 4;
        c[3] = 6;
        c[4] = 1;
        c[5] = 2;

        d[1] = 2;
        d[2] = 1;
        d[3] = 4;
        d[4] = 1;
        d[5] = 4;

        v[1] = 6;
        v[2] = 5;
        v[3] = 7;
        v[4] = 3;
        v[5] = 8;

        deal(nCount,cMax,dMax,c,d,v);
    }
}

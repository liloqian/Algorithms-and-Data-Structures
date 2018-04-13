package com.leo.sword.problem.problem29;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:41 2018/3/19
 **/
public class CutRope {
    private static int cut(int len){
        if (len == 2){
            return 1;
        }
        if (len < 2) {
            return 0;
        }
        if (len == 3) {
            return 2;
        }

        int[] product = new int[len+1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] =3;

        int max = 0;

        for (int i = 4; i <= len; i++){
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int pro = product[j] * product[i - j];
                if (max < pro) {
                    max = pro;
                }
            }
            product[i] = max;
        }

        return product[len];
    }

    public static void main(String[] args) {
        System.out.println(cut(4));
    }
}

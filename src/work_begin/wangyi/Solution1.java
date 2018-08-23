package work_begin.wangyi;

import java.util.Scanner;

/**
 * Created by leo on 2018/8/11.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i =  0 ; i < m ; i++) {
            arr[i] = scanner.nextInt();
        }

        //deal
        int[] rowCountArr = new int[n];
        for (int i = 0 ; i < m ; i++) {
            rowCountArr[arr[i]-1]++;
        }

        int ret = rowCountArr[0];
        for (int i = 1 ; i < rowCountArr.length ; i++) {
            if (ret > rowCountArr[i]) {
                ret = rowCountArr[i];
            }
        }

        System.out.println(ret);
    }
}

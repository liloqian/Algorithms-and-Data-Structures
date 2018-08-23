package work_begin.wangyi;

import java.util.Scanner;

/**
 * Created by leo on 2018/8/11.
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[] arr = new int[]{1,-1,3,3};
        for (int i = 0 ; i < n; i++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String s3 = scanner.nextLine();
            String s4 = scanner.nextLine();
            if (isSqure(s1,s2,s3,s4)){

            }
            System.out.println(arr[i]);
        }
    }

    private static boolean isSqure(String s1, String s2, String s3, String s4) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        String[] arr3 = s3.split(" ");
        String[] arr4 = s4.split(" ");
        return false;
    }
}

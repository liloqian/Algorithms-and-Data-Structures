package work_begin.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by leo on 2018/8/11.
 */
public class Solution2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int classDurationTime = scanner.nextInt();
//        if (classDurationTime <= 0) {
//            System.out.println(0);
//            return;
//        }
//        int wakeTime = scanner.nextInt();
//        boolean isCal = false;
//        if (wakeTime > 0) {
//            isCal = true;
//        }
//        int[] valueArr = new int[classDurationTime];
//        for (int i = 0 ; i < classDurationTime ; i++) {
//            valueArr[i] = scanner.nextInt();
//        }
//        int[] wakeFlag = new int[classDurationTime];
//        for (int i = 0 ; i < classDurationTime ; i++) {
//            wakeFlag[i] = scanner.nextInt();
//        }
//
//        // deal
//        int retValue = 0;
//        // 本来就醒的情况
//        for (int i = 0 ; i < classDurationTime ; i++) {
//            if (wakeFlag[i] == 1) {
//                retValue += valueArr[i];
//            }
//        }
//        if (!isCal) {
//            System.out.println(retValue);
//            return;
//        }
//
//        int[] wakeFor = new int[classDurationTime];
//        for (int i = 0 ;i < classDurationTime ; i++) {
//            if (wakeFlag[i] == 0) {
//                int tempTime = i + wakeTime;
//                int tempSum = 0;
//                for (int j = i ; j < classDurationTime && j < tempTime; j++) {
//                    tempSum += valueArr[j];
//                }
//                wakeFor[i] = tempSum;
//            }
//        }
//
//        int maxChoice = 0;
//        int tempCount = wakeFlag[0];
//        for (int i = 1 ; i < classDurationTime ; i++) {
//            if (tempCount < wakeFor[i]) {
//                tempCount = wakeFor[i];
//                maxChoice = i;
//            }
//        }
//
//
//        // 叫醒那一次
//        int temp = maxChoice + wakeTime;
//        for (int i = maxChoice ; i < classDurationTime && i < temp ; i++) {
//            if (wakeFlag[i] == 0) {
//                retValue += valueArr[i];
//            }
//        }
//
//        System.out.println(retValue);
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int classDurationTime = scanner.nextInt();
        if (classDurationTime <= 0) {
            System.out.println(0);
            return;
        }
        int wakeTime = scanner.nextInt();
        boolean isCal = false;
        if (wakeTime > 0) {
            isCal = true;
        }
        int[] valueArr = new int[classDurationTime];
        for (int i = 0 ; i < classDurationTime ; i++) {
            valueArr[i] = scanner.nextInt();
        }
        int[] wakeFlag = new int[classDurationTime];
        for (int i = 0 ; i < classDurationTime ; i++) {
            wakeFlag[i] = scanner.nextInt();
        }

        // deal
        int retValue = 0;
        // 本来就醒的情况
        for (int i = 0 ; i < classDurationTime ; i++) {
            if (wakeFlag[i] == 1) {
                retValue += valueArr[i];
            }
        }
        if (!isCal) {
            System.out.println(retValue);
            return;
        }

        int[] arrRet = new int[classDurationTime];
        for (int i = 0 ; i < classDurationTime ; i++) {
            int tempSum = 0;
            int tempCount = i + wakeTime;
            for (int j = i ; j < tempCount && j < classDurationTime ; j++) {
                if (wakeFlag[j] == 0) {
                    tempSum += valueArr[j];
                }
            }

            arrRet[i] = retValue + tempSum;
        }

        Arrays.sort(arrRet);

        System.out.println(arrRet[arrRet.length-1]);
    }
}

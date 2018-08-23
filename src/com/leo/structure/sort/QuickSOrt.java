package com.leo.structure.sort;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:32 2018/1/16
 * @Javadoc
 * */
public class QuickSOrt {

//    private static int division(int[] datas,int left,int right){
//        int base = datas[left];
//
//        while (left<right){
//            while (left < right && datas[right] >= base){
//                right--;
//            }
//
//            datas[left] = datas[right];
//
//            while (left < right && datas[left] < base){
//                left++;
//            }
//
//            datas[right] = datas[left];
//        }
//
//        datas[left] = base;
//        return left;
//    }
//
//    private static void quickSort(int[] datas,int left ,int right){
//        if(left < right){
//            int base = division(datas,left,right);
//            quickSort(datas,left,base-1);
//            quickSort(datas,base+1,right);
//        }
//    }

    public static void main(String[] args) {
        int[] data = DataFactory.getData();
        DataFactory.printArr(data);
        quickSort(data,0,data.length-1);
        DataFactory.printArr(data);
    }
    private static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int baseIndex = quickSortCore(data,left,right);
            quickSort(data,left,baseIndex-1);
            quickSort(data,baseIndex+1,right);
        }
    }

    private static int quickSortCore(int[] data, int left, int right) {
        int base = data[left];
        while (left < right) {
            while (left < right && data[right] >= base) {
                right--;
            }
            data[left] = data[right];
            while (left < right && data[left] < base) {
                left++;
            }
            data[right] = data[left];
        }
        data[right] = base;
        return left;
    }


}

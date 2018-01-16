package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:26 2018/1/15
 **/
public class DataFactory {
    public static final int DATA_SZIE = 19;

    public static int[] getData(){
        int[] arr = new int[DATA_SZIE];
        for(int i = 0 ; i < arr.length ;i++){
            arr[i] = (int) (Math.random()*1000%100);
        }
        return arr;
    }

    public static void printArr(int[] datas){
        for(int i = 0 ; i < datas.length ;i++){
            System.out.print(datas[i]+" ");
        }
        System.out.println();
    }

    public static void swap(int[] datas, int j, int i) {
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

}

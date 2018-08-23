package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:02 2018/1/16
 **/
public class DirectInsertSort {

    private static void directInsertSort(int[] datas){
        for (int i = 1 ; i < datas.length ; i++) {
            if (datas[i] < datas[i-1]) {
                int temp = datas[i];
                int j ;
                for ( j = i - 1 ; j >= 0 && datas[j] > temp ; j--) {
                    datas[j+1] = datas[j];
                }
                datas[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] datas = DataFactory.getData();
        DataFactory.printArr(datas);
        directInsertSort(datas);
//        insert(datas);
        DataFactory.printArr(datas);
    }

    private static void insert(int[] datas) {
        for (int i = 1 ; i < datas.length ;i++) {
            int temp = datas[i];
            if (datas[i] > datas[i-1]) {
                continue;
            }
            int j ;
            for ( j = i - 1; j > 0 ; j--) {
                if (temp < datas[j]) {
                    datas[j + 1] = datas[j];
                }else {
                    break;
                }
            }
            datas[j + 1] = temp;
        }
    }
}

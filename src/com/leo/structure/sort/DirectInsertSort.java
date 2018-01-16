package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:02 2018/1/16
 **/
public class DirectInsertSort {

    private static void directInsertSort(int[] datas){
        int temp ;
        for(int i = 1 ; i < datas.length ;i++){
            if(datas[i] < datas[i-1]){ //需要插入排序
                temp = datas[i];
                int j;
                for( j = i-1 ; j >= 0 && datas[j] > temp ;j--){ //j>0 && datas[j]>temp 顺序很重要
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
        DataFactory.printArr(datas);
    }
}

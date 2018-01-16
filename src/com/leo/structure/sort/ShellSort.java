package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description : shell sort is a improved insert sort
 * @Date: Created in 10:53 2018/1/16
 **/
public class ShellSort {


    private static void shellSort(int[] datas) {
        for(int gap = datas.length / 2; gap > 0 ;gap /= 2){
            for(int j = gap ; j < datas.length ;j++){
                for( int k = j - gap ; k>=0 && datas[k] > datas[k+gap] ; k -= gap){
                    DataFactory.swap(datas,k,k+gap);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] datas = DataFactory.getData();
        DataFactory.printArr(datas);
        shellSort(datas);
        DataFactory.printArr(datas);
    }

}

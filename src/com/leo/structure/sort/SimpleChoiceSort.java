package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:54 2018/1/15
 **/
public class SimpleChoiceSort {

    private static void simpleChoiceSort(int[] datas){
        int tempMin ;
        for(int i = 0 ;i < datas.length - 1;i++){
            tempMin = i;
            for(int j = i+1 ; j < datas.length ;j++){
                if(datas[tempMin] > datas[j]){
                    tempMin = j;
                }
            }
            if(tempMin != i){
                DataFactory.swap(datas,i,tempMin);
            }
        }
    }

    public static void main(String[] args) {
        int[] datas = DataFactory.getData();
        DataFactory.printArr(datas);
        simpleChoiceSort(datas);
        DataFactory.printArr(datas);
    }

}

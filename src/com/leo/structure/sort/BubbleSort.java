package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:21 2018/1/15
 **/
public class BubbleSort {

    /**
     * 基础版本
     * */
    private static void bubbleSortBased(int[] datas){
        for(int i = 0 ; i < datas.length ;i++){
            for(int j = datas.length - 1; j > i ;j--){
                if(datas[j]<datas[j-1]){
                    DataFactory.swap(datas,j,j-1);
                }
            }
        }
    }

    /**
     * 改进版本,针对2,1,3,4,5,6,7,9,8 解决类似这种情况
     * */
    private static void bubbleSortAdvanced(int[] datas){
        boolean isOk = true;
        for(int i = 0 ; i < datas.length && isOk; i++){
            isOk = false;
            for(int j = datas.length -1 ; j > i;j--){
                if(datas[j] < datas[j-1]){
                    DataFactory.swap(datas,j,j-1);
                    isOk = true;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] datas = DataFactory.getData();
        DataFactory.printArr(datas);
        System.out.println("----");
        bubbleSortBased(datas);
//        bubbleSortAdvanced(datas);
        DataFactory.printArr(datas);
    }

}

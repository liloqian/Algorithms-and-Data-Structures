package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 19:36 2018/1/16
 **/
public class MergeSort {

    /**
     * 合并两个数组
     * */
    private static void mergeArray(int[] datas,int first,int mid,int last,int[] temp){
        // i-m  j-n
        int i = first,j = mid+1;
        int m =mid,   n = last;

        int k = 0;

        while ( i <= m && j <= n){
            if(datas[i] < datas[j]){
                temp[k++] = datas[i++];
            }else {
                temp[k++] = datas[j++];
            }
        }

        while (i <= m){
            temp[k++] = datas[i++];
        }

        while (j <= n){
            temp[k++] = datas[j++];
        }

        for(i = 0 ; i < k ;i++){
            datas[first+i] = temp[i];
        }

    }

    private static void mergeSort(int[] datas,int first,int last,int[] temp){
        if(first < last){
            int mid = (first + last) / 2;
            mergeSort(datas,first,mid,temp);
            mergeSort(datas,mid+1,last,temp);
            mergeArray(datas,first,mid,last,temp);
        }
    }

    public static void main(String[] args) {
        int[] datas = DataFactory.getData();
        int[] temp = new int[datas.length];

        DataFactory.printArr(datas);

        mergeSort(datas, 0 , datas.length - 1 , temp);

        DataFactory.printArr(datas);
    }
}

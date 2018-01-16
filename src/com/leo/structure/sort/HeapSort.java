package com.leo.structure.sort;

/**
 * @Author: qian
 * @Description : heap sort is advanced choice sort
 * @Date: Created in 17:10 2018/1/16
 **/
public class HeapSort {

    private static void heapSort(int[] datas){
        //循环建立初始堆
        for(int i = datas.length / 2; i>=0 ;i--){
            heapAdjust(datas,i,datas.length);
        }

        //根节点是最大值，循环把根节点放最后
        for(int i = datas.length - 1; i>0 ;i--){
            //最后一个和第一个元素交换位置
            int temp = datas[i];
            datas[i] = datas[0];
            datas[0] = temp;
            //更新堆
            heapAdjust(datas , 0 , i);
        }
    }

    private static void heapAdjust(int[] datas,int parent,int length){
        int temp = datas[parent];
        int child = 2*parent+1;
        while ( child < length ){
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if(child+1<length && datas[child]<datas[child+1]){
                child++;
            }
            //如果父节点的值已经大于孩子节点的值，直接结束
            if(temp >= datas[child]){
                break;
            }
            // 把孩子结点的值赋给父结点
            datas[parent] = datas[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2*parent+1;
        }
        datas[parent] = temp;
    }

    public static void main(String[] args) {
        int[] datas = DataFactory.getData();
        DataFactory.printArr(datas);
        heapSort(datas);
        DataFactory.printArr(datas);
    }
}

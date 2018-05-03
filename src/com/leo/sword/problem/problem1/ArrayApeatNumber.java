package com.leo.sword.problem.problem1;

import com.leo.structure.sort.DataFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: qian
 * @Description: 打印数组中重复的数字
 * @Date: Created in 21:56 2018/3/17
 **/
public class ArrayApeatNumber {

    /**
     * 先排序  在判断
     * */
    public static List repeatNumberOfTwoByPower(int[] arr){
        // 排序 插入排序
        insertSort(arr);
        DataFactory.printArr(arr);
        // 判断
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= arr.length-1;i++) {
            if (arr[i] == arr[i-1] ) {
                set.add(arr[i]);
            }
        }
        return new ArrayList(set);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i-1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && arr[j] > temp; j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,5,3,2,2};

        System.out.println(repeatNumberOfTwoByPower(arr));
        
        System.out.println(repeatNumberTwoByHash(arr));
    }

    /**
     * 数组建立哈希表的思想
     * */
    private static List repeatNumberTwoByHash(int[] arr) {
        // 找到最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 根据哈希表思想建立数组
        int[] hash = new int[max+1];
        for (Integer i : arr) {
            hash[i]++;
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0 ; i < hash.length ;i++) {
            if (hash[i] > 1) {
                ret.add(i);
            }
        }

        return ret;
    }
}

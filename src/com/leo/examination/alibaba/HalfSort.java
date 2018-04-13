package com.leo.examination.alibaba;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:04 2018/4/3
 **/
public class HalfSort {

    private static boolean sort(int arr[], int aim){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > aim) {
                right = mid - 1;
            }else if (arr[mid] < aim) {
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,6,7};
        System.out.println(sort(arr,3));
    }
}

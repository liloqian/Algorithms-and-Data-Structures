package com.leo.sword.problem.problem37;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:39 2018/3/23
 **/
public class InversePairSort {
    //采用归并排序
    int count = 0;
    public int InversePairs(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        mergeSort(array, 0, array.length-1);

        return count;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int division = (left + right) / 2;
            mergeSort(array, left, division);
            mergeSort(array, division+1, right);
            mergeCore(array, left, division, right);
        }
    }

    private void mergeCore(int[] array, int left, int division, int right) {
        int arrOneLeft = left, arrTwoLeft = division+1;
        int arrOneRight = division, arrTwoRight = right;

        int[] temp = new int[right-left+1];
        int k = 0;
        while (arrOneLeft <= arrOneRight && arrTwoLeft <= arrTwoRight) {
            if (array[arrOneLeft] < array[arrTwoLeft]) {
                temp[k++] = array[arrOneLeft++];
            }else {
                temp[k++] = array[arrTwoLeft++];
                count += (division - arrOneLeft + 1);
                count %= 1000000007;
            }
        }

        while (arrOneLeft <= arrOneRight) {
            temp[k++] = array[arrOneLeft++];
        }
        while (arrTwoLeft <= arrTwoRight) {
            temp[k++] = array[arrTwoLeft++];
        }

        for(int i = 0 ;i < k;i++){
            array[i+left] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(new InversePairSort().InversePairs(arr));
    }
}

package com.leo.sword.problem.problem32;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:49 2018/3/21
 **/
public class BinarySortTreeBack {
    //找规律
    public boolean VerifySquenceOfBST(int [] sequence) {
       if (sequence.length == 0){
           return false;
       }
       return VerifySquenceOfBSTCore(sequence);
    }

    private boolean VerifySquenceOfBSTCore(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }
        int root = sequence[sequence.length-1];
        ArrayList<Integer> left = new ArrayList<>();
        int i = -1;
        //左子树
        for ( i = 0 ; i < sequence.length - 1 ;i++) {
            if (sequence[i] < root) {
                left.add(sequence[i]);
            }else {
                break;
            }
        }
        //右子树
        ArrayList<Integer> right = new ArrayList<>();
        for (int j = i ; j < sequence.length - 1;j++) {
            if (sequence[j] < root) {
                return false;
            }else {
                right.add(sequence[j]);
            }
        }

        //转化为数组
        return VerifySquenceOfBSTCore(convertListToArray(left))
                && VerifySquenceOfBSTCore(convertListToArray(right));
    }

    private int[] convertListToArray(List<Integer> lists){
        int[] arr = new int[lists.size()];
        for (int i = 0 ; i < lists.size() ;i++) {
            arr[i] = lists.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,8,6,12,16,14,10};
        new BinarySortTreeBack().VerifySquenceOfBST(test);
    }
}

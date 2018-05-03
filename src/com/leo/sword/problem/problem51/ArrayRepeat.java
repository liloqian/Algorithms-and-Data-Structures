package com.leo.sword.problem.problem51;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Date: Created in 15:39 2018/3/24
 **/
public class ArrayRepeat {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
       boolean[] tempFlag = new boolean[length];
       for (int i = 0 ; i < length ;i++) {
           if (tempFlag[numbers[i]]) {
               duplication[0] = numbers[i];
               return true;
           }
           tempFlag[numbers[i]] = true;
       }
       return false;

    }
}

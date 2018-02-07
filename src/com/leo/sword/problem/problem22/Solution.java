package com.leo.sword.problem.problem22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @Date: Created in 10:35 2018/2/7
 **/
public class Solution {

    /**
     * 运行时间：17ms
     * 占用内存：8516k
     * */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0) {
            return false;
        }
        List<Integer> stack = new ArrayList<>();

        for (int i = 0, j = 0 ; i < pushA.length ;i++) {
            stack.add(pushA[i]);
            while (j < popA.length && stack.get(stack.size()-1) == popA[j]) {
                stack.remove(stack.size()-1);
                j++;
            }
        }

        return stack.isEmpty();
    }


}

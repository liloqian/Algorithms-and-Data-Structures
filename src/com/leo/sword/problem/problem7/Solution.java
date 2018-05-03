package com.leo.sword.problem.problem7;

import java.util.Stack;

/**
 * @Author: qian
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 运行时间：17ms
 * 占用内存：10368k
 * @Date: Created in 17:25 2018/2/1
 **/
public class Solution {
    Stack<Integer> stackPush = new Stack<Integer>();   //压入
    Stack<Integer> stackPop = new Stack<Integer>();   //弹出

    public void push(int node) {
        if(stackPop.size() == 0){
            stackPush.push(node);
        }else {
            int size = stackPop.size();
            for (int i = 0; i < size; i++) {
                stackPush.push(stackPop.pop());
            }
            stackPush.push(node);
        }
    }

    public int pop() {
        if(stackPush.size() == 0){
            return stackPop.pop();
        }else {
            int size = stackPush.size();
            for(int i = 0 ; i < size ;i++){
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        solution.push(4);
        System.out.println(solution.pop());
        solution.push(5);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}

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
    Stack<Integer> stack1 = new Stack<Integer>();   //压入
    Stack<Integer> stack2 = new Stack<Integer>();   //弹出

    public void push(int node) {
        if(stack2.size() == 0){
            stack1.push(node);
        }else {
            int size = stack2.size();
            for (int i = 0; i < size; i++) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }
    }

    public int pop() {
        if(stack1.size() == 0){
            return stack2.pop();
        }else {
            int size = stack1.size();
            for(int i = 0 ; i < size ;i++){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
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

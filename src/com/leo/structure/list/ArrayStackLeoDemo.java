package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:02 2017/11/30
 **/
public class ArrayStackLeoDemo {
    public static void main(String[] args) {
        ArrayStackLeo<String> stack = new ArrayStackLeo<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        System.out.println(stack.isEmpty());
        System.out.println(stack.toString());
        stack.clear();
        System.out.println(stack.toString());
    }
}

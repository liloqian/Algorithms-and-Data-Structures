package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:52 2017/11/30
 **/
public class LinkStackLeoDemo {
    public static void main(String[] args) {
        LinkStackLeo<String> stackLeo = new LinkStackLeo<>();
        stackLeo.push("one");
        stackLeo.push("two");
        stackLeo.push("three");
        stackLeo.push("four");

//        System.out.println(stackLeo.toString());
//        System.out.println(stackLeo.size());
        System.out.println(stackLeo.pop());
        System.out.println(stackLeo.pop());
        System.out.println(stackLeo.pop());
        System.out.println(stackLeo.pop());
        System.out.println(stackLeo.pop());

//        System.out.println(stackLeo.toString());
//        System.out.println(stackLeo.size());

    }
}

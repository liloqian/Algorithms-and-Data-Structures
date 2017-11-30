package com.leo.structure.list;

import java.util.Stack;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 11:44 2017/11/30
 **/
public class DLinkListLeoDemo {
    public static void main(String[] args) {
        DLinkListLeo<String> list = new DLinkListLeo<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list.size());
        System.out.println(list.removeFirst());
        System.out.println(list.size());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
        System.out.println(list.size());
//        System.out.println(list.toString());
//        System.out.println(list.size());
//        list.printInfo();
//        list.add("leo",1);
//        System.out.println(list.size());
//        System.out.println(list.toString());
//        System.out.println(list.removeFirst());
//        System.out.println(list.toString());
//        System.out.println(list.size());

    }
}

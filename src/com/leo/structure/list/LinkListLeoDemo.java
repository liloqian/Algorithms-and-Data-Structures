package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 23:02 2017/11/29
 **/
public class LinkListLeoDemo {
    public static void main(String[] args) {
        LinkListLeo<String> linkListLeo = new LinkListLeo<>();
        linkListLeo.add("one");
        linkListLeo.add("two");
        linkListLeo.add("three");
        linkListLeo.add("four");
//        System.out.println(linkListLeo.remove(0));
//        System.out.println(linkListLeo.toString());
//        linkListLeo.clear();
//        System.out.println(linkListLeo.size());
        System.out.println(linkListLeo.toString());
        linkListLeo.add(3,"leo");
        System.out.println(linkListLeo.toString());
//        System.out.println(linkListLeo.toString());
//        System.out.println(linkListLeo.size());
//        System.out.println(linkListLeo.add(3,"leo"));
//        System.out.println(linkListLeo.toString());
//        System.out.println(linkListLeo.size());

    }
}

package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:43 2017/11/29
 **/
public class ArrayListLeoDemo {
    public static void main(String[] args) {
        ArrayListLeo<String> listLeo = new ArrayListLeo<>();
        listLeo.add("one");
        listLeo.add("two");
        listLeo.add("three");
        listLeo.add("four");
        System.out.println(listLeo.toString());
        listLeo.add(1,"leo");
        System.out.println(listLeo.toString());


//        ArrayListLeo<Integer> listLeo = new ArrayListLeo<>();
//        listLeo.add(1);
//        listLeo.add(2);
//        listLeo.add(3);
//        listLeo.add(4);
//        System.out.println(listLeo.toString());
//        listLeo.add(1,5);
//        listLeo.add(1,7);
//        System.out.println(listLeo.toString());
//        System.out.println(listLeo.indexOf(7));
    }
}

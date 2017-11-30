package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:53 2017/11/30
 **/
public class ArrayQueueLeoDemo {
    public static void main(String[] args) {
        ArrayQueueLeo<String> queueLeo = new ArrayQueueLeo<>();

        queueLeo.add("one");
        queueLeo.add("two");
        queueLeo.add("three");
        queueLeo.add("four");
        queueLeo.add("four");
        queueLeo.add("four");
        queueLeo.add("four");
        queueLeo.add("four");
        queueLeo.add("four");
        queueLeo.add("four");

        System.out.println(queueLeo);

        System.out.println(queueLeo.take());
        System.out.println(queueLeo.take());

        queueLeo.add("four");
        queueLeo.add("four");

        System.out.println(queueLeo);
    }
}

package com.leo.test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:10 2018/5/10
 **/
@AnnotationLeo
public class Test {

//    {
//        System.out.println("普通代码块\n");
//    }
//
//    static {
//        System.out.println("静态代码块\n");
//    }
//
//    public Test(){
//        System.out.println("构造函数\n");
//    }



    public static void main(String[] args) {


        System.out.println((char)('0'+'0'));
//        int[] a = new int[3];
//        int[][] b = new int[3][4];
//        System.out.println(a.getClass().getName() +"  "+b);
//        Test t1 = new Test();
//        System.out.println(t1.toString() + "  "  +Integer.toHexString(t1.hashCode()));
    }

    private static int  me() {
        int a = 6;
        try {
            a = a / 0;
            return a;
        }catch (ArithmeticException e) {
            e.printStackTrace();
            return a;
        }finally {
            return 3;
        }
    }


}



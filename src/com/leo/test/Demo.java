package com.leo.test;

/**
 * Created by leo on 2018/6/10.
 */
public class Demo {
    private String str = "leo";

    public static void main(String[] args) {
        new StringBuffer().toString().replaceAll(" ","%20");
    }

    private void say(){
        System.out.print("say: ");
    }

    private void say(String str){
        System.out.print("say: "+str);
    }
}

package com.leo.sword.problem.problem2;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 14:53 2018/2/1
 **/
public class SingletonByInnerClass {

    private SingletonByInnerClass(){}

    public static SingletonByInnerClass getInstance(){
        return Singleton.instance;
    }

    private static class  Singleton{
        private static SingletonByInnerClass instance = new SingletonByInnerClass();
    }
}

package com.leo.sword.problem.problem2;

/**
 * @Author: qian
 * @Description: 单例模式，懒汉式
 * @Date: Created in 11:23 2018/2/1
 **/
public class Singleton {

    private static Singleton instance = null;
    private Singleton(){ }
    /**懒汉式，线程不安全*/
    public static Singleton getInstanceLazyManDanger(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    /**懒汉式，线程安全效率低下*/
    public static synchronized Singleton getInstanceLazyManSafe(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    /**双重检查*/
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

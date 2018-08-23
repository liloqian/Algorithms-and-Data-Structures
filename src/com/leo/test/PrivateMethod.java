package com.leo.test;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by leo on 2018/6/10.
 */


public class PrivateMethod {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class<?> classDemo = Class.forName("com.leo.test.Demo");
//        Object o = classDemo.newInstance();
//
//        System.out.println(ClassLoader.getSystemClassLoader());
//
//        Field field = classDemo.getDeclaredField("str");
//        field.setAccessible(true);
//
//
//        Method method = classDemo.getDeclaredMethod("say",new Class[]{String.class});
//        method.setAccessible(true);
//        method.invoke(o,(String)field.get(o));
//
//        Lock lock = new ReentrantLock();
//        Condition readCondition = lock.newCondition();
//
//        lock.lock();
//        try {
//            readCondition.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        lock.unlock();
//    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[][] a = new int[1][1];
        System.out.println(a);
        System.out.println(a.hashCode());

        int[] b = new int[1];
        System.out.println(b);
        Class<?> cl = NewThreadTest.class;
        Object o = cl.newInstance();
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(NewThread.class)) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        m.setAccessible(true);
                        try {
                            m.invoke(o);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }else {
                m.setAccessible(true);
                m.invoke(o);
            }
        }
    }
}

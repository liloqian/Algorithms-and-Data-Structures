package com.leo.test;

/**
 * Created by leo on 2018/6/10.
 */
public class NewThreadTest {


    private void sayNoAnnotation(){
        System.out.println("say in thread: "+Thread.currentThread().getId());
    }

    @NewThread
    private void sayInAnnotation(){
        System.out.println("say in thread: "+Thread.currentThread().getId());
    }


}

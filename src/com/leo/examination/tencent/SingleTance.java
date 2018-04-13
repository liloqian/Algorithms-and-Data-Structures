package com.leo.examination.tencent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 16:05 2018/3/29
 **/
public class SingleTance {
    private SingleTance(){}

    private static class InnerClass{
        static SingleTance instance = new SingleTance();
    }

    public static SingleTance getInstance() {
        return InnerClass.instance;
    }
}

package com.leo.test;

import java.lang.annotation.*;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:10 2018/5/10
 **/

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationLeo {
    int id() default 1;
    String msg() default "leo";
}

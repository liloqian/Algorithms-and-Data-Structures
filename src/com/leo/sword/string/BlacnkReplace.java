package com.leo.sword.string;

import java.util.List;

/**
 * @Author: qian
 * @Description ：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * @Date: Created in 20:37 2017/11/6
 **/
public class BlacnkReplace {

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));
        System.out.println(replaceSpace1(new StringBuffer("We Are Happy.  ")));
    }

    /**直接使用api
     *  内部使用的是正则表达式
     * */
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

    /**
     *
     * 运行时间：21ms
     占用内存：22248k
     * */
    public static String replaceSpace1(StringBuffer str) {
       String strString = str.toString();
       char[] strChar = strString.toCharArray();

       StringBuffer sb = new StringBuffer();
       for(int i = 0 ; i < str.length() ; i++){
           if(strChar[i] != ' '){
               sb.append(strChar[i]);
           }else {
               sb.append("%20");
           }
       }
       return sb.toString();
    }
}

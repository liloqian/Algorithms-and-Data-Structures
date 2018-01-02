package com.leo.structure.String;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:43 2017/12/5
 **/
public class StringCompareLeo {


    /**
     * 比较两个字符串
     * @param str1   输入的字符串1
     * @param str2   输入的字符串2
     * @return  0  str1 == str2
     *          -1  str1 < str2
     *           1  str1 > str2
     * */
    private static int compare(String str1, String str2){
        char[] cStr1 = str1.toCharArray();
        char[] cStr2 = str2.toCharArray();
        int len = Math.min(cStr1.length,cStr2.length);

        for(int i = 0 ; i < len ;i++){
            if( cStr1[i] == cStr2[i]){
                continue;
            }else if( cStr1[i] > cStr2[i]){
                return 1;
            }else {
                return -1;
            }
        }

        if(cStr1.length == cStr2.length){
            return 0;
        }else if(cStr1.length > cStr2.length){
            return 1;
        }else {
            return -1;
        }

    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abd";

        System.out.println(compare(s1,s2));
        System.out.println(s1.compareTo(s2));

    }
}

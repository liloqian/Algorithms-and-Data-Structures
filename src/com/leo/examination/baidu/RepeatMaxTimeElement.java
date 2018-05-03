package com.leo.examination.baidu;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:21 2018/4/22
 **/
public class RepeatMaxTimeElement {
    public static void main(String[] args) {
        String str = "hellooobaaadaaaidu2018";

        // simple algorithm
        Map<Character, Integer> map = new HashMap<>() ;
        char[] chars = str.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (map.get(chars[i]) != null) {
                map.put(chars[i],map.get(chars[i])+1);
            }else {
                map.put(chars[i],1);
            }
        }

        char ret = ' ';
        int max = 1;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ret = entry.getKey();
            }
        }
        System.out.println(ret);

        /**
        // hash algorithm
        char[] chars = str.toCharArray();
        int max = -1;
        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] > max) {
                max = chars[i];
            }
        }

        int[] hashArr = new int[max+1];
        for (int i = 0 ; i < chars.length ; i++) {
            hashArr[chars[i]]++;
        }

        int tempMax = hashArr[0];
        int retChar = 0;
        for (int i = 1 ; i < hashArr.length ;i++) {
            if (tempMax < hashArr[i]) {
                tempMax = hashArr[i];
                retChar = i;
            }
        }

        System.out.println((char)retChar);
         */


    }
}

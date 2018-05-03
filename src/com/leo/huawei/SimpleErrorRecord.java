package com.leo.huawei;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:23 2018/4/25
 **/
public class SimpleErrorRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            String file = temp.split(" ")[0];
            String[] tempChar = file.split("\\\\");
            String fileName = tempChar[tempChar.length-1];
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16 , fileName.length());
            }
            fileName += "#";
            fileName += temp.split(" ")[1];
            if (map.get(fileName) != null) {
                map.put(fileName,map.get(fileName)+1);
            }else {
                map.put(fileName,1);
            }
        }
        List<String> list = new ArrayList<>();
        map.forEach((key, value) -> {
            String[] temp = key.split("#");
            list.add(temp[0] + " " + temp[1] + " " + value);
        });

        if (list.size() > 8) {
            for (int i = list.size() - 8 ; i < list.size() ; i++) {
                System.out.println(list.get(i));
            }
        }else {
            for (int i = 0 ; i < list.size() ; i++) {
                System.out.println(list.get(i));
            }
        }
    }
}

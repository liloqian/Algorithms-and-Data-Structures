package com.leo.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 14:56 2018/4/25
 **/
public class MergeTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0 ; i < count ; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (map.get(key) == null) {
                map.put(key,value);
            }else {
                map.put(key,value+map.get(key));
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}

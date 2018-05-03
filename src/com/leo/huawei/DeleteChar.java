package com.leo.huawei;

import java.util.*;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&tPage=2&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 22:10 2018/4/26
 **/
public class DeleteChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
            char[] arr = str.toCharArray();
            for (char c : arr) {
                if (map.get(c) != null) {
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c, 1);
                }
            }
            int min = 20;
            for (Character c : map.keySet()) {
                if (map.get(c) < min) {
                    min = map.get(c);
                }
            }
            Set<Character> canOut = new HashSet<>();
            for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                if (entry.getValue() > min) {
                    canOut.add(entry.getKey());
                }
            }

            for (char c : arr) {
                if (canOut.contains(c)) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}

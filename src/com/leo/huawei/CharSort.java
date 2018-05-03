package com.leo.huawei;

import java.util.*;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/2de4127fda5e46858aa85d254af43941?tpId=37&tqId=21257&tPage=2&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 17:40 2018/4/27
 **/
public class CharSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] arr = scanner.nextLine().toCharArray();
            List<Character> list = new ArrayList<>();
            for (char c : arr) {
                list.add(c);
            }
            Collections.sort(list, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if (o1 > o2) {
                        return 1;
                    }else if (o1 < o2) {
                        return -1;
                    }else {
                        return 0;
                    }
                }
            });
            for (char c : list) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

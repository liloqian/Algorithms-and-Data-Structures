package com.leo.huawei;

import java.util.*;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&tqId=21237&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 15:51 2018/4/25
 **/
public class StrSortByClassical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < count ; i++) {
            list.add(scanner.next());
        }
        Collections.sort(list); // 默认就是古典排序 小-》大
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        for (String str : list) {
            System.out.println(str);
        }
    }
}

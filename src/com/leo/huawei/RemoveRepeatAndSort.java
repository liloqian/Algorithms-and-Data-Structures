package com.leo.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 10:52 2018/4/25
 **/
public class RemoveRepeatAndSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (scanner.hasNext()) { //多行数据
            int count = scanner.nextInt();
            for (int i = 0 ; i < count ;i++) {
                set.add(scanner.nextInt());
            }
            for (int i : set) {
                System.out.println(i);
            }
            set.clear();
        }
    }
}

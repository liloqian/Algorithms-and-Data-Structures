package com.leo.huawei;

import java.util.Scanner;

/**
 * @Author: qian
 * @Description:https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * @Date: Created in 10:38 2018/4/25
 **/
public class StrFinalLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str.split(" ")[str.split(" ").length-1].length());
    }
}

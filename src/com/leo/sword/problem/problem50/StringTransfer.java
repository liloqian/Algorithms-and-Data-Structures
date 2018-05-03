package com.leo.sword.problem.problem50;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Date: Created in 11:49 2018/3/24
 **/
public class StringTransfer {
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        boolean isHaveFlag = judgeFlag(str.charAt(0));
        int startBit = 0;
        if (isHaveFlag) {
            startBit = 1;
        }
        char[] data = str.toCharArray();

        // 判断合法性
        for (int i = startBit;i < data.length ;i++) {
            if (!judgeIsNumber(data[i])) {
                return 0;
            }
        }

        // 转换为数字
        int temp = 0;
        for (int i = startBit;i < data.length ;i++) {
            temp = (data[i] - '0') + temp * 10 ;
        }
        if (isHaveFlag && data[0] == '-') {
            return temp * (-1);
        }else {
            return temp;
        }
    }

    private boolean judgeIsNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean judgeFlag(char c) {
        if (c == '+' || c == '-') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int hha = new StringTransfer().StrToInt("-2147483648");
        System.out.println(hha);
    }
}

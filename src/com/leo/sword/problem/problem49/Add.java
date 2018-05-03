package com.leo.sword.problem.problem49;

/**
 * @Author: qian
 * @Description:https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Date: Created in 11:24 2018/3/24
 **/
public class Add {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;  // 考虑进位
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}

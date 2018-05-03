package com.leo.leetCode.problem02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/22f9d7dd89374b6c8289e44237c70447?tpId=46&tqId=29031&tPage=1&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * @Date: Created in 10:45 2018/4/1
 **/
public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>();
        for (String str : tokens) {
            list.add(str);
        }

        while (list.size() > 1) {
            int i = 0 ;
            String operator = null;
            for (i = 0 ; i < list.size() ; i++) {
                if (isOperator(list.get(i))) {
                    operator = list.get(i);
                    break;
                }
            }
            int numberOneIndex = i - 2;
            int numberOne = Integer.parseInt(list.get(numberOneIndex));
            int numberTwo = Integer.parseInt(list.get(numberOneIndex+1));
            int temp = calculate(numberOne, numberTwo, operator);
            list.remove(numberOneIndex);
            list.remove(numberOneIndex);
            list.remove(numberOneIndex);
            list.add(numberOneIndex,temp+"");
        }

        return Integer.parseInt(list.get(0));
    }

    private int calculate(int numberOne, int numberTwo, String operator) {
        if (operator.equals("+")) {
            return numberOne + numberTwo;
        }
        if (operator.equals("-")) {
            return numberOne - numberTwo;
        }
        if (operator.equals("*")) {
            return numberOne * numberTwo;
        }else {
            return numberOne / numberTwo;
        }
    }

    private boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-")
                || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] temp = new String[]{"2","1","+","3","*"};
        System.out.println(new EvaluateRPN().evalRPN(temp));
    }
}

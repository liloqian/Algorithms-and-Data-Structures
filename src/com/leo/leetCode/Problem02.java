package com.leo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:45 2018/4/1
 **/
public class Problem02 {
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
        System.out.println(new Problem02().evalRPN(temp));
    }
}

package com.leo.sword.problem.problem45;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 9:44 2018/3/24
 **/
public class ReverseStr {
    public String ReverseSentence(String str) {
        String[] temp = str.split(" ");
        if (temp.length <= 1){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length-1 ; i > 0; i--) {
            sb.append(temp[i]+" ");
        }
        sb.append(temp[0]);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStr().ReverseSentence("I am a student "));
    }
}

package com.leo.sword.problem.problem54;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:46 2018/3/25
 **/
public class CharStreamFirst {
    char[] hashArr = new char[256];
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        hashArr[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char temp : sb.toString().toCharArray()) {
            if (hashArr[temp] == 1) {
                return temp;
            }
        }
        return '#';
    }
}

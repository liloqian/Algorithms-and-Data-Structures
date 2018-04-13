package com.leo.interview;


import java.io.*;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 16:37 2018/3/27
 **/
public class FileAllUpCase {

    FileInputStream fis = null;
    public static final int FLAG = 'z'-'Z';

    public FileAllUpCase(FileInputStream fis) {
        this.fis = fis;
    }

    public int read(byte[] chars) throws IOException {
        int count = fis.read(chars);
        for (int i = 0 ; i < count ;i++) {
            chars[i] = (byte) (chars[i] + FLAG);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        FileAllUpCase fileAllUpCase = new FileAllUpCase(new FileInputStream(new File("E:\\IDEA_workd_dir\\SwordOffer\\src\\com\\leo\\interview\\aaa")));
        byte[] temp = new byte[100];
        int count = fileAllUpCase.read(temp);
        System.out.println(new String(temp));
        System.out.println(count);
    }
}

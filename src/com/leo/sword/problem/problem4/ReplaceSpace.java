package com.leo.sword.problem.problem4;

/**
 * @Author: qian
 * @Description: 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Date: Created in 14:58 2018/2/1
 **/
public class ReplaceSpace {

    /**
     * SDK
     * */
    public String replaceSpaceBySDK(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

    /**
     * 从前往后移动需要O(n*n)，从后往前只需要O(n)
     * 运行时间：23ms
     * 占用内存：9024k
     * */
    public String replaceSpace(StringBuffer str) {
        char[] ori = str.toString().toCharArray();
        int spaceNumber = 0;
        for(int i = 0 ;i < ori.length ;i++){
            if(ori[i] == ' '){
                spaceNumber++;
            }
        }

        char[] dst = new char[ori.length + spaceNumber*2];

        int skipSpace = 0;
        for(int i = 0 ; i < ori.length ;i++){
            int dstTemp = i + skipSpace*2;
            if(ori[i] != ' '){
                dst[dstTemp] = ori[i];
            }else {
                dst[dstTemp] = '%';
                dst[++dstTemp] = '2';
                dst[++dstTemp] = '0';
                skipSpace++;
            }
        }

        return new String(dst);
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("We Are Happy.");
        System.out.println(new ReplaceSpace().replaceSpace(sb));
    }
}

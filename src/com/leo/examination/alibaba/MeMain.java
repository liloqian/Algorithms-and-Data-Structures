package com.leo.examination.alibaba;

import java.util.Arrays;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:48 2018/3/30
 **/
public class MeMain {
    static int process(int width, int[] modules) {
        // 排序
        Arrays.sort(modules);
        // 标志位
        boolean[] flag = new boolean[modules.length];

        int ret = 0;
        int tempDiff = 0;
        // 全部防止后会退出
        while (true){
            int i;
            boolean tempFlag = false;
            for (i = modules.length - 1 ;i >= 0 ; i--) {
                if(!flag[i]){
                    tempFlag = true;
                    flag[i] = true;
                    break;
                }
            }
            if (!tempFlag) {
                break;
            }

            tempDiff = width - modules[i];
            for (int j = 0 ; j < modules.length ;j++) {
                if (!flag[j] && modules[j] <= tempDiff) {

                    flag[j] = true;
                    break;
                }
            }
            ret++;
        }
        return ret;
    }

    private static void printArr(boolean[] ar){
        for(boolean b : ar) {
            System.out.print(b+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        int[] arr = new int[]{1,2,3,3,4,5,6,7};
        System.out.println(new MeMain().process(7
                ,arr));

//        Scanner in = new Scanner(System.in);
//        int res;
//
//        int _width;
//        _width = Integer.parseInt(in.nextLine().trim());
//
//        int _modules_size = 0;
//        _modules_size = Integer.parseInt(in.nextLine().trim());
//        int[] _modules = new int[_modules_size];
//        int _modules_item;
//        for(int _modules_i = 0; _modules_i < _modules_size; _modules_i++) {
//            _modules_item = Integer.parseInt(in.nextLine().trim());
//            _modules[_modules_i] = _modules_item;
//        }
//
//        res = process(_width, _modules);
//        System.out.println(String.valueOf(res));

    }
}

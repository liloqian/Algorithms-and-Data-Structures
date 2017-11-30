package com.leo.sword.arr;

/**
 * @Author: qian
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Date: Created in 21:27 2017/11/6
 **/
public class ReverseNumberMin {
    public static void main(String[] args) {

    }

    /**暴力解决 全遍历
     * 运行时间：541ms
     * 占用内存：34552k
     * */
    public int minNumberInRotateArray(int [] array) {
        if(array.length <= 0 ){
            return 0;
        }
        int min = array[0];
        for(int i = 0 ;i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }

    /**
     *  运行时间：481ms
     *  占用内存：34648k
     *  遍历一部分
     * */
    public int minNumberInRotateArray1(int [] array) {
        if(array.length <= 0 ){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        for(int i = 1 ;i<array.length;i++){
            if( array[i] < array[i-1]){
                return array[i];
            }
        }
        return -1;
    }


}

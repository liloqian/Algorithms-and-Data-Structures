package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 19:56 2017/11/30
 **/
public class ArrayStackLeo <T> {

    public static final int DEFAULT_SIZE = 10;

    //用数组来作为栈
    private Object[] mData;
    private int mSize;
    //保存栈顶位置
    private int mTop;
    /**
     * 初始化数组，默认大小为DEFAULT_SIZE
     * */
    public ArrayStackLeo(){
        this(DEFAULT_SIZE);
    }
    public ArrayStackLeo(int size){
        mData = new Object[size];
        mSize= size;
        mTop = -1;
    }

    /**
     * 压入数据到栈顶
     * */
    public void push(T t){
        if(mTop >= mSize){
            return;
        }
        mData[++mTop] = t;
    }

    /**
     * 从栈顶去出数据，然后top-1
     * */
    public T pop(){
        if(mTop < 0){
            return null;
        }
        T ret = (T) mData[mTop];
        mData[mTop--] = null;
        return ret;
    }

    /**
     * 判断是否是空栈
     * */
    public boolean isEmpty(){
        return mTop == -1;
    }

    /**
     * 清空栈
     * */
    public boolean clear(){
        for(int i = 0 ; i < mTop ;i++){
            mData[i] = null;
        }
        mTop = -1;
        return true;
    }

    /**
     * 返回栈的大小
     * */
    public int size(){
        return mTop+1;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0 ; i <= mTop ;i++){
            str += mData[i];
            str += " ";
        }
        return str;
    }
}

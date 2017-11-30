package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:35 2017/11/29
 **/
public class ArrayListLeo<E> {
    public static final int DEFAULT_SIZE = 10;

    //存储数据的数组
    private Object[] mData;
    private int mCurrent;
    private int mSize;

    /**
     * 构造方法
     * @param size : 初始化数组大小
     */
    public ArrayListLeo(int size){
        this.mData = new Object[size];
        mSize = size;
        mCurrent = 0;
    }
    public ArrayListLeo(){
        this.mData = new Object[DEFAULT_SIZE];
        mSize = DEFAULT_SIZE;
        mCurrent = 0;
    }

    /***
     * 增加一个成员到末尾
     * @param e
     */
    public void add(E e){
        mData[mCurrent++] = e;
    }

    /**
     * 增加一个元素到指定位置，后续的移位
     * @param index
     * @param e
     * @return
     */
    public Boolean add(int index,E e){
        if( !rangeCheck(index) ){
            return false;
        }
        for(int i = mCurrent; i > index ; i--){
            mData[i] = mData[i-1];
        }
        mData[index] = e;
        mCurrent++;
        return true;
    }

    /**
     * 返回指定位置的成员
     * @param index
     * @return
     */
    public E get(int index){
        return (E) mData[index];
    }

    /**
     * 匹配成员，返回下表
     * @param e
     * @return ：匹配成功返回下标，负责返回-1
     */
    public int indexOf(E e){
        for(int i = 0 ; i < mCurrent ;i++){
            if(e.equals(mData[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 得到集合有效数据大小
     * @return
     */
    public int size(){
        return mCurrent;
    }

    /**
     * 清空链表
     * @return
     */
    public boolean clear(){
        for(int i = 0 ; i < mCurrent ; i++){
            mData[i] = null;
        }
        for(int i = 0 ; i < mSize; i++){
            if(mData[i]!=null){
                return false;
            }
        }
        mCurrent = 0;
        return true;
    }

    /**
     * 判断是否为空
     * @return
     */
    public Boolean isEmpty(){
        return mCurrent == 0;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0 ; i < mCurrent ;i++){
            str += mData[i] ;
            str += " ";
        }
        return str;
    }

    /**
     * 边界检查
     * @param index
     * @return: ture代表ok
     */
    private Boolean rangeCheck(int index) {
        if( index < 0 || index > (mCurrent-1) ){
            return false;
        }
        return true;
    }
}
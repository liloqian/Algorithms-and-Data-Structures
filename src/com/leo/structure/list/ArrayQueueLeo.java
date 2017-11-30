package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 21:41 2017/11/30
 **/
public class ArrayQueueLeo<T> {

    private static final int DEFAULT_SIZE = 8;

    private Object[] mData;
    private int rear,front; //尾巴和头部
    private int MAX_SIZE;   //队列总长度
   // private int mSize;      //队列有效长度,可以通过rear和front计算得到

    public ArrayQueueLeo(){
        this(DEFAULT_SIZE);
    }
    public ArrayQueueLeo(int size){
        this.mData = new Object[size];
        MAX_SIZE = size;
        rear = 0;
        front = 0;
    }

    /**
     * 压入队列
     * */
    public void add(T t){
        //判断队列是否未满
        if( (rear+1)%MAX_SIZE == front ){
            System.err.println("队列已满...");
            return;
        }
        mData[rear] = t;
        rear = (rear+1)%MAX_SIZE;
    }

    /**
     * 出队列
     * 不阻塞啊
     * */
    public T take(){
        if(rear == front){
            System.err.println("队列为null");
            return null;
        }
        T ret = (T) mData[front];
        front = (front+1)%MAX_SIZE;
        return ret;
    }

    /**
     * 队列大小
     * */
    public int size(){
        return (rear - front + MAX_SIZE)%MAX_SIZE;
    }

    @Override
    public String toString() {
        String str = "";
        int index = front;
        for (int i = 0 ; i < size() ; i++){
            str += mData[index];
            str += " ";
            index = (index+1+MAX_SIZE)%MAX_SIZE;
        }
        return str;
    }
}

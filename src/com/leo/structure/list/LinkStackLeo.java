package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:31 2017/11/30
 **/
public class LinkStackLeo<T> {

    private class Node<T>{
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> mLabel ;
    private int mSize;

    public LinkStackLeo() {
        mLabel = new Node<>(null,null);
        mSize = 0;
    }

    /**
     * 增加元素到栈顶
     * */
    public void push(T t){
        Node<T> top = mLabel.next;
        Node<T> addNew = new Node<>(t,null);
        mLabel.next = addNew;
        addNew.next = top;
        mSize++;
    }

    /**
     * 出栈一个元素
     * */
    public T pop(){
        if(mSize <= 0){
            return null;
        }
        T ret = mLabel.next.data;
        mLabel.next = mLabel.next.next;
        mSize--;
        return ret;
    }

    /**
     * 数据个数
     * */
    public int size(){
        return mSize;
    }

    public boolean isEmpty(){
        return mSize == 0;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> temp = mLabel;
        while (temp.next != null){
            temp = temp.next;
            str += temp.data;
            str += " ";
        }
        return str;
    }
}



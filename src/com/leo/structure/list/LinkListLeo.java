package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:56 2017/11/29
 **/
public class LinkListLeo<T> {
    /**
     * @T 数据域
     * @nextNode 指针域
     * */
     class Node<T>{
        public T data;
        public Node<T> nextNode;

        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    private int mSize = 0;
    private Node<T> header; //头指针

    public LinkListLeo(){
        header = new Node<>(null,null);
    }

    /**
     * 添加一个新的成员到末尾
     * @param t : 增加一个成员到末尾
     */
    public void add(T t){
        Node<T> data = new Node<>(t,null);
        Node<T> temp = header;
        while (temp.nextNode != null){
            temp = temp.nextNode;
        }
        temp.nextNode = data;
        mSize++;
    }

    /**
     * 添加一个新的成员到第index位置
     * @param index : 0代表第一个位置，和数组不同
     * @param t : 插入的数据
     * @return  ： 插入成功还是失败
     */
    public boolean add(int index,T t){
        Node<T> temp = header;
        int current = 0;
        //查找第i-1个节点
        while ( temp != null && current < index){
            temp = temp.nextNode;
            current++;
        }
        if(current != index || temp == null){  //判断
            return false;
        }
        Node<T> data = new Node<>(t,null);
        data.nextNode = temp.nextNode;
        temp.nextNode = data;
        mSize++;
        return true;
    }

    /**
     * 删除index位置的元素
     * @return : 返回删除节点的数据
     * **/
    public T remove(int index){
        Node<T> temp = header;
        int current = 0;
        //查找第i-1个节点
        while ( temp != null && current < index){
            temp = temp.nextNode;
            current++;
        }
        if(current != index || temp == null){  //判断
            return null;
        }
        Node<T> removeData = temp.nextNode;
        temp.nextNode = removeData.nextNode;
        mSize--;
        return removeData.data;
    }


    public boolean clear(){
        Node<T> temp = header;
        Node<T> delete ;
        while (temp.nextNode != null){
            delete = temp;
            temp = temp.nextNode;
            delete.nextNode = null;
            mSize--;
        }
        return true;
    }

    /**
     * 链表的长度
     * @return : 返回链表长度
     * */
    public int size(){
        return mSize;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> temp = header;
        while (temp.nextNode != null){
            str += temp.nextNode.data;
            str += " ";
            temp = temp.nextNode;
        }
        return str;
    }
}

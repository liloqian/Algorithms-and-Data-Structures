package com.leo.structure.list;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 11:33 2017/11/30
 **/
public class DLinkListLeo<T> {

    class Node<T>{
        T data;
        Node<T> prior;
        Node<T> next;

        public Node(T data, Node<T> prior, Node<T> next) {
            this.data = data;
            this.prior = prior;
            this.next = next;
        }
    }

    Node<T> header;
    private int mSize;


    public DLinkListLeo(){
        header = new Node<>(null,null,null);
        header.next = header;
        header.prior = header;
        mSize = 0;
    }

    /**
     * 增加一个对象到链表尾部
     * */
    public void add(T t){
        Node<T> addNew = new Node<>(t,null,null);
        Node<T> tail = header.prior;
        addNew.prior = tail;
        addNew.next = header;
        header.prior = addNew;
        tail.next = addNew;
        mSize++;
    }

    /**
     * @Parm t :    数据
     * @Parm index : 添加的位置
     * */
    public Boolean add(T t,int index){
        Node<T> first = header;
        if(mSize < index ){
            return false;
        }
        int current = 0;
        while ( current < index){
            first = first.next;
            current++;
        }
        Node<T> last = first.next;
        Node<T> addNew = new Node<>(t,null,null);
        addNew.next = last;
        addNew.prior = first;
        first.next = addNew;
        last.prior = addNew;
        mSize++;
        return true;
    }

    /**
     * 移除第一个数据
     * */
    public T removeFirst(){
        Node<T> temp = header;
        if(mSize<=0){
            return null;
        }
        Node<T> removeData = temp.next;
        temp = removeData.next;
        header.next = temp;
        temp.prior = header;
        mSize--;
        return removeData.data;
    }

    /**
     * 移除最后一个
     **/
    public T removeLast(){
        if(mSize<=0){
            return null;
        }
        Node<T> removeData = header.prior;
        removeData.prior.next = header;
        header.prior = removeData.prior;
        mSize--;
        return removeData.data;
    }

    /**
     *  return
     * */
    public int size(){
        return mSize;
    }

    /**
     * 打印信息，调试使用的，检查是否是双向训练链表
     * */
    public void printInfo(){
        Node<T> temp = header;
        while (temp.next != header){
            System.out.println(temp.next.toString() + "  "+ temp.toString()+"  "+temp.prior.toString() + "  "+temp.data);
            temp = temp.next;
        }
        System.out.println(temp.next.toString() + "  "+ temp.toString()+"  "+temp.prior.toString() + "  "+temp.data);
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> temp = header;
        while (temp.next != header){
            temp = temp.next;
            str += temp.data;
            str += " ";
        }
        return str;
    }

}

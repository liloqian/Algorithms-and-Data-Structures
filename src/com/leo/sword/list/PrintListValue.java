package com.leo.sword.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: qian
 * @Description: 输入一个链表，从尾到头打印链表每个节点的值。
 * @Date: Created in 21:00 2017/11/6
 **/
public class PrintListValue {

    class ListNode {
        int val;
        ListNode next =null;
        ListNode(int val){
            this.val =val;
        }
    }

    /**
     *  暴力解法
     * 输入一个链表，从尾到头打印链表每个节点的值。
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> listHeadToTail = new ArrayList<>();
        ArrayList<Integer> listTailToHead = new ArrayList<>();

        ListNode current = listNode;
        while (current != null){
            listHeadToTail.add(current.val);
            current = current.next;
        }

        for(int i = listHeadToTail.size()-1 ; i >= 0 ; i--){
            listTailToHead.add(listHeadToTail.get(i));
        }

        return listTailToHead;
    }



    /**
     *  递归解决
     *  反转的可以考虑栈和递归
     *  可以使用栈解决的都可以使用递归解决，本质是一样的
     * */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
        ArrayList<Integer> retList = new ArrayList<>();

        ListNode current = listNode;
        if(current != null){
            if(current.next != null){
                retList = printListFromTailToHead1(current.next);
            }
            retList.add(current.val);
        }
        return retList;
    }


    /**
     * 运行时间：14ms
     占用内存：8408k
     * */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> retList = new ArrayList<>();
        ListNode current = listNode;
        while (current != null){
            stack.push(current.val);
            current = current.next;
        }
        while (!stack.empty()){
            retList.add(stack.pop());
        }
        return retList;
    }

}

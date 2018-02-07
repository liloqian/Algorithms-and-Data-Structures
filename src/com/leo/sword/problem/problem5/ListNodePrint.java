package com.leo.sword.problem.problem5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: qian
 * @Description: 输入一个链表，从尾到头打印链表每个节点的值
 * @Date: Created in 15:25 2018/2/1
 **/
public class ListNodePrint {

    /**
     * 从前到后遍历，然后reverse
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode current = listNode;
        while (current != null){
            arrayList.add(current.val);
            current = current.next;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    /**
     * 递归实现
     * */
    public ArrayList<Integer> printListFromTailToHeadRecursion(ListNode listNode) {
        ArrayList<Integer> arr ;
        if(listNode.next != null){
            arr = printListFromTailToHeadRecursion(listNode.next);
        }else {
            arr = new ArrayList<>();
        }
        arr.add(listNode.val);

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,2,4,6,8,10};

        ListNode[] list = new ListNode[arr.length];
        for(int i = 0; i < arr.length ;i++){
            list[i] = new ListNode(arr[i]);
            if(i > 0){
                list[i-1].next = list[i];
            }
        }

        List<Integer> l = new ListNodePrint().printListFromTailToHeadRecursion(list[0]);
        for(Integer i : l) {
            System.out.println(i+"  ");
        }

    }
}

package com.leo.sword.problem.problem15;

/**
 * @Author: qian
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @Date: Created in 17:41 2018/2/5
 **/
public class FindKthToTail {

    /**
     * 运行时间：22ms
     * 占用内存：8828k
     * */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode first,second;
        second = null;
        first = head;
        int count = 0;
        while (first != null) {
            first = first.next;
            if (count == (k - 1)) {
                second = head;
            }
            if (count > (k - 1)) {
               second = second.next;
            }
            count++;
        }
        return second;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(FindKthToTail(listNode1,3).toString());
    }
}

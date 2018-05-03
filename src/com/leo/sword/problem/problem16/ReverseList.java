package com.leo.sword.problem.problem16;


/**
 * @Author: qian
 * @Description: 输入一个链表，反转链表后，输出链表的所有元素。
 * @Date: Created in 11:32 2018/2/6
 **/
public class ReverseList {
    /**
     * 运行时间：26ms
     * 占用内存：8704k
     * */
    private static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentPre = head;
        ListNode current = head.next;
        ListNode currentNext = null;
        head.next = null;
        while (current != null) {
            currentNext = current.next;
            current.next = currentPre;
            currentPre = current;
            current = currentNext;
        }

        return currentPre;
    }

    private static ListNode reverseListNodeByRecursion(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        ListNode nextReverse = reverseListNodeByRecursion(listNode.next);
        listNode.next = null;
        nextReverse.next = listNode;
        return listNode;
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


//        System.out.println(ReverseList(listNode1));
        reverseListNodeByRecursion(listNode1);
        System.out.println(listNode5);
//        ListNode listNode = ReverseList(listNode1);
//        printNode(listNode);

    }
}

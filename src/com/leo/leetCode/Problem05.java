package com.leo.leetCode;

/**
 * @Author: qian
 * @Description: Sort a linked list using insertion sort.
 * @Date: Created in 19:33 2018/4/1
 **/
public class Problem05 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = head;  // 返回的头结点
        ListNode current = head.next; // 进行比较的当前节点
        ListNode currentBefore = head;  // 进行比较的当前节点前一个
        while (current != null) {
            if (current.val < currentBefore.val) {  // 当前节点需要插入
                currentBefore.next = current.next;  //
                ListNode temp = ret;                // 当前节点需要插入的的下一个节点
                ListNode tempBefore = null;         // 当前节点需要插入的的上一个节点
                while (temp.val < current.val) {
                    tempBefore = temp;
                    temp = temp.next;
                }
                if (tempBefore == null) {
                    current.next = ret;
                    ret = current;
                }else {
                    tempBefore.next = current;
                    current.next = temp;
                }
                current = currentBefore.next;
            }else {  // 当前节点不用插入
                currentBefore = current;
                current = currentBefore.next;
            }
        }
        return ret;
    }
}


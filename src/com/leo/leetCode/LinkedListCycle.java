package com.leo.leetCode;

/**
 * @Author: qian
 * @Description: Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 * @Date: Created in 17:05 2018/4/9
 **/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slowly = head;
        while (slowly.next != null && fast.next != null && fast.next.next != null && fast != slowly) {
            fast = fast.next.next;
            slowly = slowly.next;
        }
        if (fast == slowly) {
            return true;
        }else {
            return false;
        }
    }
}

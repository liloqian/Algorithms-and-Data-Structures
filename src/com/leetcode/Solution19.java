package com.leetcode;

/**
 * Created by leo on 2018/8/12.
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode fast = root;
        ListNode slowly = root;
        while (--n >= 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slowly = slowly.next;
        }
        slowly.next = slowly.next.next;

        return root.next;
    }
}

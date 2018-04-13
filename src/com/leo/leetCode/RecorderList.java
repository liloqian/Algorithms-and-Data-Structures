package com.leo.leetCode;

/**
 * @Author: qian
 * @Description: Given a singly linked list L: L 0→L 1→…→L n-1→L n,reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * @Date: Created in 15:17 2018/4/9
 * @URL: https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=46&tqId=29037&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 **/
public class RecorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        recorderListCore(head);
    }

    private void recorderListCore(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode finalCur = head.next;
        ListNode finalPre = head;
        while (finalCur.next != null) {
            finalCur = finalCur.next;
            finalPre = finalPre.next;
        }
        finalPre.next = null;
        ListNode tempNewHead = head.next;
        head.next = finalCur;
        finalCur.next = tempNewHead;
        recorderListCore(tempNewHead);
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        new RecorderList().reorderList(one);
    }
}

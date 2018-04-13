package com.leo.leetCode;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:46 2018/4/1
 **/
public class Problem04 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeSort(sortList(head), sortList(midNext));
    }

    private ListNode mergeSort(ListNode one, ListNode two) {
        ListNode pHead = new ListNode(0);
        ListNode ret = pHead;
        while (one != null && two != null) {
            if (one.val < two.val) {
                pHead.next = one;
                one = one.next;
            }else {
                pHead.next = two;
                two = two.next;
            }
            pHead = pHead.next;
        }
        if (one == null) {
            pHead.next = two;
        }else {
            pHead.next = one;
        }

        return ret.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        return second;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

package com.leo.leetCode.problem04;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/d75c232a0405427098a8d1627930bea6?tpId=46&tqId=29033&tPage=1&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * @Date: Created in 15:46 2018/4/1
 **/
public class SortList {
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

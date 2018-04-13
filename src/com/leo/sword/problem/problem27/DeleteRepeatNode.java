package com.leo.sword.problem.problem27;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 15:14 2018/3/21
 **/
public class DeleteRepeatNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode current ;

        if (pHead.next.val == pHead.val) {
            current = pHead.next.next;
            while (current != null && current.val == pHead.val) {
                current = current.next;
            }
            return deleteDuplication(current);
        }else {
            current = pHead.next;
            pHead.next = deleteDuplication(current);
            return pHead;
        }

    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
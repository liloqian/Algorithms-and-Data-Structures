package com.leo.sword.problem.problem25;

import java.util.Stack;

/**
 * @Author: qian
 * @Description: 输入两个链表，找出他们的的第一个公共节点
 * @Date: Created in 10:31 2018/3/21
 **/
public class CommonListNode {
    // 用栈进行模拟从链表后面开始遍历
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stackOne = new Stack<>();
        Stack<ListNode> stackTwo = new Stack<>();

        while (pHead1 != null) {
            stackOne.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stackTwo.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode ret = null;

        while (stackOne.size() > 0 && stackTwo.size() > 0) {
            ListNode tempOne = stackOne.pop();
            ListNode tempTwo = stackTwo.pop();
            if (tempOne == tempTwo) {
                ret = tempOne;
            }
            if (tempOne != tempTwo) {
                break;
            }
        }

        return ret;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
package com.leo.leetCode;

/**
 * @Author: qian
 * @Description: Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up: Can you solve it without using extra space?
 * @Date: Created in 15:52 2018/4/9
 **/
public class LinkedListCycyleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 判读是否是个环
        ListNode fast = head.next;
        ListNode slowy = head;
        while (slowy.next != null && fast.next != null && fast.next.next != null &&  fast != slowy) {
            fast = fast.next.next;
            slowy = slowy.next;
        }
        if (fast != slowy) {
            return null;
        }
        // 计算圆长度
        int circleLen = 1;
        ListNode temp = slowy.next;
        while (temp != slowy) {
            temp = temp.next;
            circleLen++;
        }
        // 计算圆的入口
        fast = head;
        slowy = head;
        while (circleLen-- > 0) {
            fast = fast.next;
        }
        while (fast != slowy) {
            fast = fast.next;
            slowy = slowy.next;
        }

        return slowy;

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        new LinkedListCycyleII().detectCycle(one);
    }
}

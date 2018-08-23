package com.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * Created by leo on 2018/8/12.
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode res = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.peek();
                s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.peek();
                s2.pop();
            }
            res.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = res;
            res = head;
            sum /= 10;
        }
        return res.val == 0 ? res.next : res;
    }

    private String reverse(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0 ; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution445().reverse("abcd"));
    }
}

package com.leetcode;

/**
 * Created by leo on 2018/7/27.
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retHead = new ListNode(-1);
        ListNode current = retHead;
        boolean adddFlag = false;
        while (true) {
            if (l1 != null && l2 != null) {
                int temp = l1.val + l2.val + (adddFlag ? 1 : 0);
                adddFlag = temp >= 10;
                current.next = new ListNode(temp % 10);
                current = current.next;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 == null &&  l2 == null) {
                break;
            }else if(l1 == null){
                while (l2 != null) {
                    int temp = l2.val + (adddFlag ? 1 : 0);
                    current.next = new ListNode(temp % 10);
                    adddFlag = temp >= 10;
                    current = current.next;
                    l2 = l2.next;
                }
            }else {
                while (l1 != null) {
                    int temp = l1.val + (adddFlag ? 1 : 0);
                    current.next = new ListNode(temp % 10);
                    adddFlag = temp >= 10;
                    current = current.next;
                    l1 = l1.next;
                }
            }
        }
        if (adddFlag) {
            current.next = new ListNode(1);
        }
        return retHead.next;
    }

        public ListNode addTwoNumbersBg(ListNode l1, ListNode l2) {
        long num1 = 0;
        long flga = 1;
        while (l1 != null) {
            num1 = num1 +l1.val * flga;
            flga *= 10;
            l1 = l1.next;
        }
        long num2 = 0;
        flga = 1;
        while (l2 != null) {
            num2 = num2 + l2.val * flga;
            flga *= 10;
            l2 = l2.next;
        }

        long sum = num1 + num2;
        if (sum == 0) {
            return new ListNode(0);
        }
        int first = (int) (sum % 10);
        sum /= 10;
        ListNode head = new ListNode(first);
        ListNode current = head;
        while (sum != 0) {
            current.next = new ListNode((int) (sum % 10));
            current = current.next;
            sum /= 10;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
//        node2.next = node3;

        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
//        node4.next = node5;
//        node5.next = node6;

        printListNode(node1);
        printListNode(node4);
        printListNode(new Solution2().addTwoNumbers(node1,node4));
    }

    private static void printListNode(ListNode root){
        while (root != null) {
            System.out.print(root.val+"->");
            root = root.next;
        }
        System.out.println();
    }
}


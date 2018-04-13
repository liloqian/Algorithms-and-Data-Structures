package com.leo.sword.problem.problem26;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 10:48 2018/3/21
 **/
public class CloseListNode {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 得到环内节点，同时也可以判断包含闭环
        ListNode head,tail;
        head = pHead;
        tail = pHead.next;
        ListNode closeInNode = null;
        while (true) {
            if (head == tail) {
                closeInNode = head;
                break;
            }
            if (head.next != null){
                head = head.next;
            }else {
                return null;
            }
            if(tail.next.next != null){
                tail = tail.next.next;
            }else {
                return null;
            }
        }
        // 计算换的节点数目
        int count = 1;
        ListNode tempNode = closeInNode.next;
        while (true) {
            if (tempNode == closeInNode){
                break;
            }
            tempNode = tempNode.next;
            count++;
        }
        //计算入口
        ListNode first = pHead;
        ListNode retTail = pHead;
        while (--count >= 0){
            first = first.next;
        }
        while (true) {
            if (first == retTail){
                break;
            }
            first = first.next;
            retTail = retTail.next;
        }
        return first;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
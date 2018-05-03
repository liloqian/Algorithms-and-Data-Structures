package com.leo.leetCode.problem13;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/60e43001345241ba9266cb4ee6fc6350?tpId=46&tqId=29042&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @Date: Created in 16:54 2018/4/28
 **/
public class CopyRandomList {

    // 复制每个节点到相邻后一个 - 初始化随机值 - 去除
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null ) {
            return head;
        }
        // double
        copyToAfter(head);
        // random init
        randomInit(head);
        // split
        RandomListNode ret = split(head);
        return ret;
    }

    private RandomListNode split(RandomListNode head) {
        RandomListNode ret = head.next;
        RandomListNode current = ret;
        while (current.next != null) {
            RandomListNode tempNext = current.next.next;
            current.next = tempNext;
            current = tempNext;
        }
        return ret;
    }

    private void randomInit(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private void copyToAfter(RandomListNode head) {
        while (head != null) {
            RandomListNode copyTemp = new RandomListNode(head.label);
            RandomListNode next = head.next;
            head.next = copyTemp;
            copyTemp.next = next;
            head = next;
        }
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(-1);
        RandomListNode r2 = new RandomListNode(-1);
        r1.next = r2;
        new CopyRandomList().copyRandomList(r1);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    public RandomListNode(int label) {
        this.label = label;
    }
}

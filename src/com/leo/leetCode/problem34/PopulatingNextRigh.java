package com.leo.leetCode.problem34;

import java.util.LinkedList;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/f18bc13a954f4389900b56e545feca6e?tpId=46&tqId=29063&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *  测序遍历
 * @Date: Created in 11:42 2018/5/17
 **/
public class PopulatingNextRigh {
    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode tempPre = null;
            for (int i = 0 ; i < size ; i++) {
                TreeLinkNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                if (tempPre == null) {
                    tempPre = tempNode;
                }else {
                    tempPre.next = tempNode;
                    tempPre = tempNode;
                }
            }
            tempPre.next = null;
        }
    }
}

class TreeLinkNode{
    int val;
    TreeLinkNode left,right,next;
    TreeLinkNode(int val) {
        this.val = val;
    }
}

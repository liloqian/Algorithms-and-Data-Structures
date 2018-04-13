package com.leo.sword.problem.problem53;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:28 2018/3/24
 **/
public class TwoTreeMid {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 第一种情况，存在右子树
        if (pNode.right != null) {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        // 不存在右子树
        while (pNode.next != null) {
            TreeLinkNode pRoot = pNode.next;
            if (pRoot.left ==  pNode) {
                return pRoot;
            }
            pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
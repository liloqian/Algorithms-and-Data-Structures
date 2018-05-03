package com.leo.sword.problem.problem53;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
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
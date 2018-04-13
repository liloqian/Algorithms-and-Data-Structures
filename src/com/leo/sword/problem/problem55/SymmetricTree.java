package com.leo.sword.problem.problem55;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 17:51 2018/3/25
 **/
public class SymmetricTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        return isSymmetricalCore(pRoot.left, pRoot.right);
    }

    private boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricalCore(left.right,right.left) && isSymmetricalCore(left.left, right.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
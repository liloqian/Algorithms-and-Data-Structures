package com.leo.leetCode.Problem39;

public class BlanceTree {

       public boolean isBalanced(TreeNode root)  {
        boolean ret = true;
         if (root == null) {
             return ret;
         }
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        if (Math.abs(left - right) > 1) {
            ret = false;
        }

        if (ret) {
            ret = isBalanced(root.left);
        }

        if (ret) {
            ret = isBalanced(root.right);
        }

        return ret;
    }

    private int depthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthOfBinaryTree(root.left)+1,depthOfBinaryTree(root.right)+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode  right;

    public TreeNode(int val) {
        this.val = val;
    }
}
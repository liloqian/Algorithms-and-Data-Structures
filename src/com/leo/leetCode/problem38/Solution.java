package com.leo.leetCode.problem38;

public class Solution {

    private boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return flag;
        }
        core(root,root.val,sum);
        return flag;
    }

    private void core(TreeNode root, int val, int sum) {
        if (root.left == null && root.right  == null) {
            if (val == sum) {
                flag = true;
            }
            return;
        }

        if(flag) {
            return;
        }
        if (root.left != null) {
            core(root.left, val + root.left.val, sum);
        }
        if (flag) {
            return;
        }
        if (root.right != null) {
            core(root.right, val + root.right.val, sum);
        }
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

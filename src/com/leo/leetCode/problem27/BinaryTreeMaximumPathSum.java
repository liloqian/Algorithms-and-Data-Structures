package com.leo.leetCode.problem27;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:12 2018/5/9
 **/
public class BinaryTreeMaximumPathSum {
    int maxValue = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxValue = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxValue;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, getMaxPathSum(root.left));
        int rightMax = Math.max(0,getMaxPathSum(root.right));
        maxValue = Math.max(maxValue, root.val + leftMax + rightMax);
        return Math.max(0,root.val + Math.max(leftMax,rightMax));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
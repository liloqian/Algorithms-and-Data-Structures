package com.leo.leetCode;

/**
 * @Author: qian
 * @Description: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
 * @Date: Created in 10:31 2018/4/1
 **/

public class Problem01 {
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left != null && root.right != null) {
            return  1 + Math.min(run(root.left), run(root.right));
        }else if (root.left == null) {
            return 1 + run(root.right);
        }else {
            return 1 + run(root.left);
        }

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

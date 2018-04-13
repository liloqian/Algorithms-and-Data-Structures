package com.leo.sword.problem.problem39;

/**
 * @Author: qian
 * @Description: 输入一颗二叉树，求树的深度
 * @Date: Created in 16:07 2018/3/23
 **/
public class TwoTreeDepth {

    /**
     * 自己想的
     * */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
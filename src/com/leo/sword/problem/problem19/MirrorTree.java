package com.leo.sword.problem.problem19;

/**
 * @Author: qian
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Date: Created in 17:13 2018/2/6
 **/
public class MirrorTree {

    /**
     * 运行时间：27ms
     * 占用内存：8980k
     * */
    public void Mirror(TreeNode root) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            Mirror(root.left);
        }

        if (root.right != null) {
            Mirror(root.right);
        }
    }
}

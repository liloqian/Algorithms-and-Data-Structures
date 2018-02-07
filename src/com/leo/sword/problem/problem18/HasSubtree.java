package com.leo.sword.problem.problem18;

/**
 * @Author: qian
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Date: Created in 16:40 2018/2/6
 **/
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean ret = false;

        if (root1 != null && root2 != null){
            if (root1.val == root2.val) {
                ret = DoTree1HaveTree2(root1,root2);
            }
            if (!ret) {
                ret = HasSubtree(root1.left, root2);
            }
            if (!ret) {
                ret = HasSubtree(root1.right, root2);
            }
        }

        return ret;
    }

    private boolean DoTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
           return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return DoTree1HaveTree2(root1.left, root2.left) &&
                DoTree1HaveTree2(root1.right, root2.right);
    }
}

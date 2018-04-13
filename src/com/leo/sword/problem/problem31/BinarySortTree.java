package com.leo.sword.problem.problem31;

/**
 * @Author: qian
 * @Description: 输入一颗二叉搜索树，将二叉搜索树转换为一个排序的双向链表
 * @Date: Created in 22:06 2018/3/21
 **/
public class BinarySortTree {
    //递归实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //左边转化为链表
        TreeNode left = Convert(pRootOfTree.left);
        //找到该双向链表的的最后一个节点
        TreeNode leftFinal = left;
        while (leftFinal != null && leftFinal.right != null) {
            leftFinal = leftFinal.right;
        }
        //如果左边不为null
        if (left != null) {
            pRootOfTree.left = leftFinal;
            leftFinal.right = pRootOfTree;
        }
        //右边转化为双向链表
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left != null ? left : pRootOfTree;

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
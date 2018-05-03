package com.leo.sword.problem.problem40;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 16:20 2018/3/23
 **/
public class AVLJudge {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
            return false;
        }

//        平衡二叉树不要求排序二叉树
//        if (root.left != null) {
//            if (root.left.val > root.val){
//                return false;
//            }
//        }
//        if (root.right != null) {
//            if (root.right.val < root.val) {
//                return false;
//            }
//        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    private int treeDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(treeDepth(node.left), treeDepth(node.right));
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t4.left = t2;
        t4.right = t6;
        t2.left = t1;
        t2.right = t3;
        t6.left = t5;
        t6.right = t7;

        System.out.println(new AVLJudge().IsBalanced_Solution(t4));
    }
}
class TreeNode {
    int val ;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
package com.leo.leetCode;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: Given a binary tree, return the postorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 * @Date: Created in 20:12 2018/4/1
 **/
public class Problem06 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> retList = new ArrayList<>();
        postOrderTraversalCore(retList, root);
        return retList;
    }

    private void postOrderTraversalCore(ArrayList<Integer> retList, TreeNode root) {
        if (root != null) {
            postOrderTraversalCore(retList, root.left);
            postOrderTraversalCore(retList, root.right);
            retList.add(root.val);

        }
    }
}

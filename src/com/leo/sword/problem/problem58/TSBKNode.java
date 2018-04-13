package com.leo.sword.problem.problem58;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 19:22 2018/3/25
 **/
public class TSBKNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0) {
            return null;
        }
        // 前序遍历
        ArrayList<TreeNode> list = new ArrayList<>();
        preTraverse(pRoot,list);
        // 直接返回第k个节点
        if (k > list.size()){
            return null;
        }
        return list.get(k-1);
    }

    private void preTraverse(TreeNode pRoot, ArrayList<TreeNode> list) {
        if (pRoot != null) {
            preTraverse(pRoot.left,list);
            list.add(pRoot);
            preTraverse(pRoot.right,list);
        }
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
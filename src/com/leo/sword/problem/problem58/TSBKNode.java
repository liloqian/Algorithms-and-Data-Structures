package com.leo.sword.problem.problem58;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Date: Created in 19:22 2018/3/25
 **/
public class TSBKNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0) {
            return null;
        }
        // 前序遍历
        ArrayList<TreeNode> list = new ArrayList<>();
        minTraverse(pRoot,list);
        // 直接返回第k个节点
        if (k > list.size()){
            return null;
        }
        return list.get(k-1);
    }

    private void minTraverse(TreeNode pRoot, ArrayList<TreeNode> list) {
        if (pRoot != null) {
            minTraverse(pRoot.left,list);
            list.add(pRoot);
            minTraverse(pRoot.right,list);
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
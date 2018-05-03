package com.leo.sword.problem.problem56;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Date: Created in 18:25 2018/3/25
 **/
public class LayerTraverseTree {
    // 层序遍历
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
        if  (pRoot == null) {
            return retList;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(pRoot);

        while (true) {
            if (queue.size() > 0) {
                ArrayList<TreeNode> list = new ArrayList<>();
                for (TreeNode node : queue) {
                    list.add(node);
                }
                queue.clear();
                ArrayList<Integer> tempRet = new ArrayList<>();
                for (TreeNode temp : list) {
                    tempRet.add(temp.val);
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
                retList.add(tempRet);

            }else {
                break;
            }
        }
        return retList;
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

package com.leo.sword.problem.problem61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:44 2018/3/25
 **/
public class ZPrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
        if (pRoot == null){
            return retList;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(pRoot);

        boolean flag = true;
        while (queue.size() > 0) {
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode node : queue) {
                list.add(node);
            }
            queue.clear();

            ArrayList<Integer> tempList = new ArrayList<>();
            for (TreeNode node : list) {
                tempList.add(node.val);
                boolean temp = node.left != null && queue.add(node.left);
                temp = node.right != null && queue.add(node.right);
            }
            // 按照z字形
            if (flag) {
                flag = false;
            }else {
                Collections.reverse(tempList);
                flag = true;
            }
            retList.add(tempList);
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
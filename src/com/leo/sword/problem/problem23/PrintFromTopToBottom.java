package com.leo.sword.problem.problem23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 * @Author: qian
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Date: Created in 11:13 2018/2/7
 **/
public class PrintFromTopToBottom {
    /**
     * 运行时间：18ms
     * 占用内存：8684k
     * */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            retList.add(current.val);
            if (current.left != null) {
               queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
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
package com.leo.structure.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: qian
 * @Description: 构建霍夫曼树（最优二叉树）
 * @Date: Created in 10:47 2018/4/11
 **/
public class Hoffman {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        List<TreeNode> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new TreeNode(i));
        }

        TreeNode root = createHoffman(nodes);

        printTree(root);
    }

    private static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val+" ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    private static TreeNode createHoffman(List<TreeNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            TreeNode root = new TreeNode(nodes.get(0).val + nodes.get(1).val);
            root.left = nodes.get(0);
            root.right = nodes.get(1);
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(root);
        }
        return nodes.get(0);
    }
}

class TreeNode implements Comparable<TreeNode>{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(TreeNode o) {
        if (o.val > this.val) {
            return -1;
        } else if (o.val < this.val) {
            return 1;
        }
        return 0;
    }
}

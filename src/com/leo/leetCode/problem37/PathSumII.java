package com.leo.leetCode.problem37;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/840dd2dc4fbd4b2199cd48f2dadf930a?tpId=46&tqId=29066&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * */
public class PathSumII {
    private ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return retList;
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(root.val);
        core(root,root.val,tempList,sum);

        return retList;
    }

    private void core(TreeNode root, int currentSum, ArrayList<Integer> tempList, int sum) {
        System.out.print(tempList);
        if (root.left == null && root.right == null) {
            if (currentSum == sum) {
                retList.add(new ArrayList<>(tempList));
            }
            return;
        }
        if (root.left != null) {
            tempList.add(root.left.val);
            core(root.left, currentSum+root.left.val, tempList, sum);
            tempList.remove(tempList.lastIndexOf((Object)root.left.val));
        }

        if (root.right != null) {
            tempList.add(root.right.val);
            core(root.right, currentSum+root.right.val, tempList, sum);
            tempList.remove(tempList.lastIndexOf((Object)root.right.val));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-2);
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        TreeNode node6 = new TreeNode(-1);
        node3.left = node6;

        PathSumII pathSumII = new PathSumII();
        ArrayList<ArrayList<Integer>> ret = pathSumII.pathSum(root,22);

        for (ArrayList<Integer>  temp : ret) {
            System.out.println(" ===  "+temp);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
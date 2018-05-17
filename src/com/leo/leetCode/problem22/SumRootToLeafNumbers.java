package com.leo.leetCode.problem22;

import java.util.ArrayList;

/**
 * @Author: qian
 * @Description: https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=46&tqId=29051&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @Date: Created in 20:14 2018/5/4
 **/
public class SumRootToLeafNumbers {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        temp.add(root.val);
        coreSumNumber(root);

        return sumCalculate();
    }

    private int sumCalculate() {
        int sum = 0;
        for (ArrayList<Integer> list : lists) {
            int temp = 0;
            for (int i : list) {
                temp = temp * 10 + i;
            }
            sum += temp;
        }
        return sum;
    }

    private void coreSumNumber(TreeNode root) {
        if (root.left == null && root.right == null) {
            lists.add(new ArrayList<>(temp));
            return;
        }
        if (root.left != null) {
            temp.add(root.left.val);
            coreSumNumber(root.left);
            temp.remove(temp.lastIndexOf(root.left.val));
        }
        if (root.right != null) {
            temp.add(root.right.val);
            coreSumNumber(root.right);
            temp.remove(temp.lastIndexOf(root.right.val));
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(9);
        TreeNode two = new TreeNode(0);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(2);
        TreeNode five = new TreeNode(3);
        TreeNode six = new TreeNode(4);
        TreeNode seven = new TreeNode(7);


        one.left = two;
        one.right = three;

        three.left = four;

        four.left = five;
        four.right = six;

        six.right = seven;

        System.out.println(new SumRootToLeafNumbers().sumNumbers(one));
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
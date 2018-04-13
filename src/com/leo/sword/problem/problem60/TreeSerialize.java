package com.leo.sword.problem.problem60;

/**
 * @Author: qian
 * @Description: 二叉树的序列， 存储前序与中序
 * @Date: Created in 20:12 2018/3/25
 **/
public class TreeSerialize {
    // 利用前序与中序
    String Serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder preTraverse = new StringBuilder();
        preTraverseCore(root, preTraverse);
        StringBuilder midTraverse = new StringBuilder();
        midTraverseCore(root, midTraverse);
        return preTraverse+"#"+midTraverse;
    }

    private void midTraverseCore(TreeNode root, StringBuilder midTraverse) {
        if (root != null) {
            midTraverseCore(root.left, midTraverse);
            midTraverse.append(root.val+"-");
            midTraverseCore(root.right, midTraverse);
        }
    }

    private void preTraverseCore(TreeNode root, StringBuilder preTraverse) {
        if (root != null) {
            preTraverse.append(root.val+"-");
            preTraverseCore(root.left,preTraverse);
            preTraverseCore(root.right,preTraverse);
        }
    }

    TreeNode Deserialize(String str) {
        if ("null".equals(str)){
            return null;
        }
        String[] strData = str.split("#");
        String[] preStr = strData[0].split("-");
        String[] midStr = strData[1].split("-");

        int[] pre = new int[preStr.length];
        int i = 0;
        for (String s : preStr){
            pre[i++] = Integer.valueOf(s);
        }
        int[] mid = new int[midStr.length];
        i = 0;
        for (String s : midStr) {
            mid[i++] = Integer.valueOf(s);
        }

        TreeNode retPRoot = rebuildTree(pre, mid);

        return retPRoot;
    }

    private TreeNode rebuildTree(int[] pre, int[] mid) {
        if (pre.length == 0 && mid.length == 0){
            return null;
        }
        int root = pre[0];
        int left = 0;
        while (mid[left] != root) {
            left++;
        }
        int[] preLeft = new int[left];
        int[] preRight = new int[pre.length-1-left];
        for (int i = 0 ; i < preLeft.length ;i++) {
            preLeft[i] = pre[i+1];
        }
        for (int i = 0 ; i < preRight.length ;i++) {
            preRight[i] = pre[i+left+1];
        }

        int[] midLeft = new int[left];
        int[] midRight = new int[mid.length-1-left];
        for (int i = 0 ; i < midLeft.length; i++) {
            midLeft[i] = mid[i];
        }
        for (int i = 0 ;i < midRight.length ;i++) {
            midRight[i] = mid[i+left+1];
        }

        TreeNode ret = new TreeNode(root);
        ret.left = rebuildTree(preLeft, midLeft);
        ret.right = rebuildTree(preRight, midRight);

        return ret;
    }


    public static void main(String[] args) {
        String[] temp = "112-132-#312-231-312".split("#");
        for (String str : temp) {
            String[] s = str.split("-");
            for (String s1 : s) {
                System.out.println(s1);
            }
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
package com.leo.sword.problem.problem6;


/**
 * @Author: qian
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 * @Date: Created in 15:58 2018/2/1
 **/
public class TreeRebuild {

    /**
     * 运行时间：292ms
     * 占用内存：22176k
     * */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 && in.length == 0){
            return null;
        }

        TreeNode rootTree = null;
        if(pre.length != 0 && in.length != 0 ){
            rootTree = new TreeNode(pre[0]);
            //root节点的值在中序遍历数组的下标
            int rootIndex = -1;
            //中序遍历判断root节点左右的元素数目
            int leftNumber = 0;
            for(int i = 0 ; i < in.length ;i++){
                if(in[i] != pre[0]){
                    leftNumber++;
                }else {
                    rootIndex = i;
                    break;
                }
            }

            //左边
            int[] tempPreLeft = new int[leftNumber];
            int[] tempInLeft = new int[leftNumber];
            for(int i = 0 ; i < tempPreLeft.length ;i++){
                tempPreLeft[i] = pre[i+1];
            }
            for(int i = 0 ; i < tempInLeft.length ;i++){
                tempInLeft[i] = in[i];
            }
            rootTree.left = reConstructBinaryTree(tempPreLeft,tempInLeft);

            //右边
            int[] tempPreRight = new int[pre.length - leftNumber - 1];
            int[] tempInRight = new int[pre.length - leftNumber - 1];
            for(int i = 0 ; i < tempPreRight.length ;i++){
                tempPreRight[i] = pre[i+1+leftNumber];
            }
            for(int i = 0 ; i < tempInRight.length ;i++){
                tempInRight[i] = in[i+1+leftNumber];
            }
            rootTree.right = reConstructBinaryTree(tempPreRight,tempInRight);

            return rootTree;
        }
        if(pre.length == 0 && in.length != 0){
            throw new RuntimeException("impossible");
        }

        if(pre.length != 0 && in.length == 0){
            throw new RuntimeException("impossible");
        }

        return null;
    }

    public static void main(String[] args) {

    }
}

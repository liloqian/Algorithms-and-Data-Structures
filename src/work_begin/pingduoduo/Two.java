package work_begin.pingduoduo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leo on 2018/7/22.
 */
public class Two {

    private static ArrayList<Integer> backList = new ArrayList<>();

    /**
     *   你们测试数据是不是有问题啊
     *   不加算法数据解析都错误，二三行字符串是不是长度不一样啊
     *        *   你们测试数据是不是有问题啊
     *   不加算法数据解析都错误，二三行字符串是不是长度不一样啊
     *        *   你们测试数据是不是有问题啊
     *   不加算法数据解析都错误，二三行字符串是不是长度不一样啊
     *        *   你们测试数据是不是有问题啊
     *   不加算法数据解析都错误，二三行字符串是不是长度不一样啊
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nodeNumStr = scanner.nextLine();
        String preStr = scanner.nextLine();
        String midStr = scanner.nextLine();
        String[] preArr = preStr.split(" ");
        String[] midArr =midStr.split(" ");
        int nodeNum = preArr.length;
        int[] pre = new int[nodeNum];
        int[] mid = new int[nodeNum];
        for (int i = 0 ; i < preArr.length ; i++) {
            pre[i] = Integer.valueOf(preArr[i]);
            mid[i] = Integer.valueOf(midArr[i]);
        }

        TreeNode tree = reConstructBinaryTree(pre,mid);

        backOrder(tree);
        for(int i = 0 ; i <= backList.size() - 2 ; i++) {
            System.out.print(backList.get(i)+" ");
        }
        System.out.println(backList.get(backList.size()-1));
    }

    private static void backOrder(TreeNode root) {
        if (root != null) {
            backOrder(root.left);
            backOrder(root.right);
            backList.add(root.val);
        }
    }

    private static TreeNode reConstructBinaryTree(int [] pre,int [] mid) {
        if(pre.length == 0 && mid.length == 0){
            return null;
        }

        TreeNode rootTree = null;
        if(pre.length != 0 && mid.length != 0 ){
            rootTree = new TreeNode(pre[0]);
            //中序遍历判断root节点左右的元素数目
            int leftNumber = 0;
            for(int i = 0 ; i < mid.length ;i++){
                if(mid[i] != pre[0]){
                    leftNumber++;
                }else {
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
                tempInLeft[i] = mid[i];
            }
            rootTree.left = reConstructBinaryTree(tempPreLeft,tempInLeft);

            //右边
            int[] tempPreRight = new int[pre.length - leftNumber - 1];
            int[] tempInRight = new int[pre.length - leftNumber - 1];
            for(int i = 0 ; i < tempPreRight.length ;i++){
                tempPreRight[i] = pre[i+1+leftNumber];
            }
            for(int i = 0 ; i < tempInRight.length ;i++){
                tempInRight[i] = mid[i+1+leftNumber];
            }
            rootTree.right = reConstructBinaryTree(tempPreRight,tempInRight);

            return rootTree;
        }
        if(pre.length == 0 && mid.length != 0){
            throw new RuntimeException("impossible");
        }

        if(pre.length != 0 && mid.length == 0){
            throw new RuntimeException("impossible");
        }
        return null;
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

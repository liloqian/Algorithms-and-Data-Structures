package com.leo.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:59 2017/12/28
 **/
public class TreeOfCommon<T> {

    private Node<T> root;

    /**
     * 创建一颗完全二叉树
     * */
    private void createTree(char[] data, List<Node> list){
        //先把数组变为链表
        for(int i = 0 ; i < data.length; i++){
            list.add(new Node<>(data[i],null,null));
        }

        for(int i = 0 ; i < data.length/2 -1 ; i++){
            list.get(i).setLeft(list.get(i*2+1));
            list.get(i).setRight(list.get(i*2+2));
        }

        int lastParentIndex = data.length/2 - 1;
        list.get(lastParentIndex).left = list.get(lastParentIndex*2+1);
        if( data.length % 2 == 1){
            list.get(lastParentIndex).right = list.get(lastParentIndex*2+2);
        }
    }

    private static void printCurrent(Node current) {
        System.out.print(current.getData()+" ");
    }


    /**
     * 递归前序遍历
     * */
    private static void preOrder(Node root){
        if(root != null){
            printCurrent(root);
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 递归中序遍历
     * */
    private static void midOrder(Node root){
        if(root != null){
            midOrder(root.getLeft());
            printCurrent(root);
            midOrder(root.getRight());
        }
    }

    /**
     * 递归后序遍历
     * */
    private static void backOrder(Node root){
        if(root != null){
            backOrder(root.getLeft());
            backOrder(root.getRight());
            printCurrent(root);
        }
    }

    /**
     * 非递归前序
     * */
    private static void preOrderWithStack(Node root){
        Stack<Node> stack = new Stack<>();
        Node pNode = root;
        while (pNode != null || stack.size()>0){
            while (pNode != null){
                printCurrent(pNode);
                stack.push(pNode);
                pNode = pNode.getLeft();
            }
            if(stack.size()>0){
                pNode = stack.pop();
                pNode = pNode.getRight();
            }
        }

    }

    /**
     * 非递归中序
     * */
    private static void minOrderWithStack(Node root){
        Stack<Node> stack = new Stack<>();
        Node pNode = root;
        while (pNode != null || stack.size()>0){
            while (pNode != null){
                stack.push(pNode);
                pNode = pNode.getLeft();
            }
            if(stack.size()>0){
                pNode = stack.pop();
                printCurrent(pNode);
                pNode = pNode.getRight();
            }
        }
    }


    /**
     * 非递归后序
     * */
    private static void backOrderWithStack(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Boolean> sFlag = new Stack<>();
        Node pNode = root;
        while (pNode != null || stack.size()>0 ){
            while (pNode != null){
                stack.push(pNode);
                sFlag.push(Boolean.FALSE);
                pNode = pNode.getLeft();
            }
            while (stack.size() > 0 && sFlag.peek().equals(Boolean.TRUE)){
                sFlag.pop();
                printCurrent(stack.pop());
            }
            if(stack.size() > 0){
                sFlag.pop();
                sFlag.push(Boolean.TRUE);
                pNode = stack.peek();
                pNode = pNode.getRight();
            }
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        char[] data = {'a','b','c','d','e','f','g','h','i','j'};

        TreeOfCommon<Character> treeOfCommon = new TreeOfCommon<>();
        treeOfCommon.createTree(data,list);

        System.out.println("前序");
        preOrder(list.get(0));
        System.out.println();
        preOrderWithStack(list.get(0));
        System.out.println();

        System.out.println("中序");
        midOrder(list.get(0));
        System.out.println();
        minOrderWithStack(list.get(0));
        System.out.println();

        System.out.println("后序");
        backOrder(list.get(0));
        System.out.println();

    }

    private static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}

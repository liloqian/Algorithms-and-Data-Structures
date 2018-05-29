package com.leo.structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: qian
 * @Description: 无向图的dfs 和 bfs
 * @Date: Created in 9:23 2018/5/3
 **/
public class Traverse {
    public static void main(String[] args) {
        NodeGraph a = new NodeGraph(1);
        NodeGraph b = new NodeGraph(2);
        NodeGraph c = new NodeGraph(3);
        NodeGraph d = new NodeGraph(4);
        NodeGraph e = new NodeGraph(5);

        a.neighbors.add(b);
        a.neighbors.add(c);
        a.neighbors.add(d);

        b.neighbors.add(a);
        b.neighbors.add(e);

        c.neighbors.add(a);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(b);
        e.neighbors.add(c);
        e.neighbors.add(d);

        System.out.print("dfs:");
        dfs(a);
        System.out.print("\nbfs:");
        bfs(a);
    }

    /**
     * dfs(depth first search)
     * */
    private static void dfs(NodeGraph root) {
        ArrayList<NodeGraph> list = new ArrayList<>();
        coreDfs(root, list);
    }

    private static void coreDfs(NodeGraph root, ArrayList<NodeGraph> list) {
        if (root == null) {
            return;
        }
        System.out.print(root.label+" ");
        list.add(root);
        for (NodeGraph node : root.neighbors) {
            if (!list.contains(node)) {
                list.add(node);
                coreDfs(node,list);
            }
        }
    }

    /**
     * bfs(breadth first search)
     * */
    private static void bfs(NodeGraph root) {
        if (root == null) {
            return;
        }
        System.out.print(root.label+" ");
        LinkedList<NodeGraph> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<NodeGraph> listFlag = new ArrayList<>();
        listFlag.add(root);
        while (!queue.isEmpty()) {
            NodeGraph current = queue.poll();
            for(NodeGraph node : current.neighbors) {
                if (!listFlag.contains(node)) {
                    System.out.print(node.label+" ");
                    listFlag.add(node);
                    queue.offer(node);
                }
            }
        }
    }

}

class

NodeGraph {
    int label;
    ArrayList<NodeGraph> neighbors;

    public NodeGraph(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
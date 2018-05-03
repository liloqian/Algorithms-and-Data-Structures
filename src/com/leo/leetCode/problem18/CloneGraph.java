package com.leo.leetCode.problem18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 22:21 2018/5/2
 **/
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        return bfs(node, map);
    }

    /**
     * 广度优先
     * breadth first search
     * */
    private UndirectedGraphNode bfs(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (root == null) {
            return null;
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(root.label);
        map.put(root,clone);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for(UndirectedGraphNode node : current.neighbors) {
                if (!map.containsKey(node)) {
                    clone = new UndirectedGraphNode(node.label);
                    map.put(node,clone);
                    queue.offer(node);
                }
                map.get(current).neighbors.add(node);
            }
        }
        return clone;
    }

    /**
     * 深度优先
     * Depth first Search
     **/
    private UndirectedGraphNode dfs(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (root == null) {
            return null;
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(root.label);
        map.put(root, clone);
        for(UndirectedGraphNode node : root.neighbors) {
            if (map.containsKey(node)) {
                clone.neighbors.add(map.get(node));
            }else {
                UndirectedGraphNode next = dfs(node, map);
                clone.neighbors.add(next);
            }
        }
        return clone;
    }
}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}

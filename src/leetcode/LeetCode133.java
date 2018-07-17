package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 克隆一张无向图，图中的每个节点包含一个 label （标签）和一个 neighbors （邻接点）列表 。
 * @Date: Created in 2018/7/17
 * @Modified By:
 */
public class LeetCode133 {

    class UndirectedGraphNode {
       int label;
       List<UndirectedGraphNode> neighbors;
       UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }

    Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null){
            return null;
        }
        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        if (map.containsKey(node)){
            return map.get(node);
        }else {
            map.put(node,newNode);
        }
        newNode.neighbors=buildNeighbors(node.neighbors);
        return newNode;
    }

    public List<UndirectedGraphNode> buildNeighbors(List<UndirectedGraphNode> nodes){
        List<UndirectedGraphNode> newNodes=new ArrayList<>();
        for (UndirectedGraphNode node:nodes){
            if (map.containsKey(node)){
                newNodes.add(map.get(node));
            }else {
                newNodes.add(cloneGraph(node));
            }
        }
        return newNodes;
    }
}

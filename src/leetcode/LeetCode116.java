package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 填充同一层的兄弟节点
 * @Date: Created in 下午3:48 2018/5/11
 * @Modified By:
 */
public class LeetCode116 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    Map<Integer,List<TreeLinkNode>> map=new HashMap<>();

    public void connect(TreeLinkNode root) {
        check(root,0);
        for (Integer i:map.keySet()){
            List<TreeLinkNode> nodes=map.get(i);
            for (int j=0;j<nodes.size()-1;j++){
                TreeLinkNode no1=nodes.get(j);
                TreeLinkNode no2=nodes.get(j+1);
                no1.next=no2;
            }
        }
    }

    public void check(TreeLinkNode node,int height){
        if (node==null){
            return;
        }
        if (map.containsKey(height)){
            List<TreeLinkNode> nodes=map.get(height);
            nodes.add(node);
            map.put(height,nodes);
        }else {
            List<TreeLinkNode> nodes=new ArrayList<>();
            nodes.add(node);
            map.put(height,nodes);
        }
        check(node.left,height+1);
        check(node.right,height+1);
    }

    public void connect2(TreeLinkNode root) {
        if (root == null){
            return;
        }
        Queue<TreeLinkNode> resolvingNodes = new LinkedList<TreeLinkNode>();
        resolvingNodes.offer(root);
        while (!resolvingNodes.isEmpty()){
            List<TreeLinkNode> nodesCurLevel = new ArrayList<TreeLinkNode>();
            while (!resolvingNodes.isEmpty()){
                nodesCurLevel.add(resolvingNodes.poll());
            }
            for (int nodeIdx = 0 ; nodeIdx < nodesCurLevel.size() ; nodeIdx ++){
                if (nodeIdx != nodesCurLevel.size() - 1){
                    nodesCurLevel.get(nodeIdx).next =
                            nodesCurLevel.get(nodeIdx + 1);
                }
                else{
                    nodesCurLevel.get(nodeIdx).next = null;
                }
                if (nodesCurLevel.get(nodeIdx).left != null){
                    resolvingNodes.offer(nodesCurLevel.get(nodeIdx).left);
                }
                if (nodesCurLevel.get(nodeIdx).right != null){
                    resolvingNodes.offer(nodesCurLevel.get(nodeIdx).right);
                }
            }
        }
    }
}

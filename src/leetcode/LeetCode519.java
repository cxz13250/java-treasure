package leetcode;

import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个N叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * @Date: Created in 下午9:25 2018/9/1
 * @Modified By:
 */
public class LeetCode519 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int height=0;

    public int maxDepth(Node root) {
        if (root==null){
            return height;
        }
        check(root,1);
        return height;
    }

    public void check(Node node,int height){
        List<Node> children=node.children;
        if (children==null||children.size()==0){
            this.height=Math.max(height,this.height);
            return;
        }
        for (Node n:children){
            check(n,height+1);
        }
    }
}

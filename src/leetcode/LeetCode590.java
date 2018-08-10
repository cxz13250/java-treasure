package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个N叉树，返回其节点值的后序遍历。
 * @Date: Created in 2018/8/10
 * @Modified By: *
 */
public class LeetCode590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //递归
    public List<Integer> postorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if (root == null) {
            return result;
        }
        check(root,result);
        return result;
    }

    public void check(Node node,List<Integer> list){
        if (node == null) {
            return;
        }
        List<Node> nodes=node.children;
        for (Node n:nodes){
            check(n,list);
        }
        list.add(node.val);
    }

    //非递归
    public List<Integer> postorder2(Node root) {
        List<Integer> result=new ArrayList<>();
        return result;
    }
}

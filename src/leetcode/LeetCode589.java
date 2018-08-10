package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个N叉树，返回其节点值的前序遍历。
 * @Date: Created in 2018/8/9
 * @Modified By:
 */
public class LeetCode589 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            if (node != null){
                result.add(node.val);
                List<Node> nodes=node.children;
                for (int i=nodes.size()-1;i>=0;i--){
                    stack.push(nodes.get(i));
                }
            }
        }
        return result;
    }
}

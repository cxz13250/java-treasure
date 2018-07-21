package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 给定一个N叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * @Date: Created in 上午12:10 2018/7/19
 * @Modified By:
 */
public class LeetCode429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue1=new LinkedList<>();
        Queue<Node> queue2=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        queue1.offer(root);

        while (!queue1.isEmpty()||!queue2.isEmpty()){
            if (!queue1.isEmpty()){
                List<Integer> list=new ArrayList<>();
                while (!queue1.isEmpty()){
                    Node node=queue1.poll();
                    for (Node n:node.children){
                        queue2.offer(n);
                    }
                    list.add(node.val);
                }
                result.add(list);
            }else if (!queue2.isEmpty()){
                List<Integer> list=new ArrayList<>();
                while (!queue2.isEmpty()){
                    Node node=queue2.poll();
                    for (Node n:node.children){
                        queue1.offer(n);
                    }
                    list.add(node.val);
                }
                result.add(list);
            }
        }
        return result;
    }
}

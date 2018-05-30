package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，原地将它展开为链表。
 * @Date: Created in 上午12:04 2018/5/30
 * @Modified By:
 */
public class LeetCode114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Queue<TreeNode> queue=new LinkedList<>();

    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        check(root);
        if (queue.size()==1){
            return;
        }
        TreeNode pre=queue.poll();
        TreeNode next;
        while (queue.size()>0){
            next=queue.poll();
            pre.left=null;
            pre.right=next;
            pre=next;
        }
    }

    public void check(TreeNode node){
        if (node==null){
            return;
        }
        queue.offer(node);
        if (node.left!=null){
            check(node.left);
        }
        if (node.right!=null){
            check(node.right);
        }
    }
}

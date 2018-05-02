package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * @Date: Created in 下午3:26 2018/4/30
 * @Modified By:
 */
public class LeetCode538 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int temp=0;

    public TreeNode convertBST(TreeNode root) {
        sumNode(root);
        return root;
    }

    public void sumNode(TreeNode node){
        if(node==null){
            return;
        }
        sumNode(node.right);
        node.val=node.val+temp;
        temp=node.val;
        sumNode(node.left);
    }
}

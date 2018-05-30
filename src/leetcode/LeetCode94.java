package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回它的中序 遍历。
 * @Date: Created in 上午11:26 2018/5/24
 * @Modified By:
 */
public class LeetCode94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            result.add(node.val);
            node=node.right;
        }
        return result;
    }
}

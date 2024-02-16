package leetcode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 中序遍历
 * @Date: Created in 下午12:28 2024/1/27
 * @Modified By:
 */
public class Leet94_MiddleTraversalOfBinaryTree {

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traversal(node.left, result);
        result.add(node.val);
        traversal(node.right, result);
    }

    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                cur = tmp.right;
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

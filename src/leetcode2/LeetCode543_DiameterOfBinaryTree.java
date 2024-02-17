package leetcode2;

import javafx.util.Pair;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:24 2024/2/16
 * @Modified By:
 */
public class LeetCode543_DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        Pair<Integer, Integer> res = dfs(root);
        return res.getValue();
    }

    // 左值深度，右值经过此节点的最长直径
    public static Pair<Integer, Integer> dfs(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }
        if (node.left == null && node.right == null) {
            return new Pair<>(1, 1);
        }
        Pair<Integer, Integer> leftDepth = dfs(node.left);
        Pair<Integer, Integer> rightDepth = dfs(node.right);
        return new Pair<>(Math.max(leftDepth.getKey(), rightDepth.getKey()) + 1,
                Math.max(Math.max(leftDepth.getValue(), rightDepth.getValue()), leftDepth.getKey() + rightDepth.getKey()));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(diameterOfBinaryTree(n1));
    }
}

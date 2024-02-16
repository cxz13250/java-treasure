package leetcode2;

import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:55 2024/1/14
 * @Modified By:
 */
public class Leet102_SequenceTraversalOfBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSequence = new LinkedList<>();
        queueNode.add(root);
        queueSequence.add(0);
        while (!queueNode.isEmpty() && !queueSequence.isEmpty()) {
            TreeNode treeNode = queueNode.poll();
            Integer sequence = queueSequence.poll();
            if (res.size() < sequence + 1) {
                res.add(new ArrayList<>());
            }
            List<Integer> tmp = res.get(sequence);
            tmp.add(treeNode.val);
            if (treeNode.left != null) {
                queueNode.add(treeNode.left);
                queueSequence.add(sequence+1);
            }
            if (treeNode.right != null) {
                queueNode.add(treeNode.right);
                queueSequence.add(sequence+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n2 = new TreeNode(9, n4, n5);
        TreeNode n3 = new TreeNode(20);
        TreeNode n1 = new TreeNode(3, n2, n3);
        System.out.println(new Leet102_SequenceTraversalOfBinaryTree().levelOrder(n1));
    }
}

class TreeNode {
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

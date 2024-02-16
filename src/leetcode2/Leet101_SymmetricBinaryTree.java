package leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:31 2024/2/14
 * @Modified By:
 */
public class Leet101_SymmetricBinaryTree {

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

    // 数组迭代，取对称下标
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()) {
            int size = list.size();
            if (size % 2 > 0) {
                return false;
            }
            for (int i = 0; i < size / 2; i++) {
                TreeNode l = list.get(i);
                TreeNode r = list.get(size - i - 1);
                if (l == null && r != null) {
                    return false;
                }
                if (l != null && r == null) {
                    return false;
                }
                if (l == null && r == null) {
                    continue;
                }
                if (l.val != r.val) {
                    return false;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = list.get(0);
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
                list.remove(0);
            }
        }
        return true;
    }

    // 队列迭代，控制入队顺序
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if ((n1 == null || n2 == null) || (n1.val != n2.val)) {
                return false;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return true;
    }

    // 递归
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        TreeNode t33 = new TreeNode(5);
        TreeNode t34 = new TreeNode(4);
        TreeNode t43 = new TreeNode(8);
        TreeNode t44 = new TreeNode(9);
        TreeNode t45 = new TreeNode(9);
        TreeNode t46 = new TreeNode(8);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t21.right = t32;
        t22.left = t33;
        t22.right = t34;
        t32.left = t43;
        t32.right = t44;
        t33.left = t45;
        t33.right = t46;

        System.out.println(isSymmetric(t1));
    }
}

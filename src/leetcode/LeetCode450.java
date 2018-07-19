package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * @Date: Created in 2018/7/19
 * @Modified By:
 */
public class LeetCode450 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return root;
        }
        TreeNode pre=root;
        TreeNode node=root;
        while (node!=null){
            if (node.val<key){
                pre=node;
                node=node.right;
            }else if (node.val>key){
                pre=node;
                node=node.left;
            }else {
                break;
            }
        }
        if (node==null){
            return root;
        } else if (node==root){
            return buildTree(node.left,node.right);
        } else{
            if (pre.left==node){
                pre.left=buildTree(node.left,node.right);
            }else {
                pre.right=buildTree(node.left,node.right);
            }
            return root;
        }
    }

    public TreeNode buildTree(TreeNode left,TreeNode right){
        if (left==null){
            return right;
        }else if (right==null){
            return left;
        }
        if (left.right==null){
            left.right=right;
            return left;
        }else {
            TreeNode pre=left;
            TreeNode node=left.right;
            while (node.right!=null){
                pre=node;
                node=node.right;
            }
            if (node.left!=null){
                pre.right=node.left;
            }else {
                pre.right = null;
            }
            node.left=left;
            node.right=right;
            return node;
        }
    }
}

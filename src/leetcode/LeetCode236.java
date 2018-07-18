package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @Date: Created in 下午3:19 2018/7/14
 * @Modified By:
 */
public class LeetCode236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root,p,q);
    }

    public TreeNode find(TreeNode node,TreeNode p,TreeNode q){
        if (node==null){
            return null;
        }
        if (node==p||node==q){
            return node;
        }
        TreeNode left=find(node.left,p,q);
        TreeNode right=find(node.right,p,q);
        if (left!=null||right!=null){
            return node;
        }
        return left==null?left:right;
    }
}

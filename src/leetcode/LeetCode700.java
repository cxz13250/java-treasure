package leetcode;

/**
 * @Author ROKG
 * @Description 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * @Date: Created in 2018/7/17
 * @Modified By:
 */
public class LeetCode700 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }else if (root.val<val){
            return searchBST(root.right, val);
        }else {
            return searchBST(root.left, val);
        }
    }
}

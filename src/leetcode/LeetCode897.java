package leetcode;

/**
 * @Author ROKG
 * @Description 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * @Date: Created in 上午12:00 2020/5/9
 * @Modified By:
 */
public class LeetCode897 {

    TreeNode node = null;
    TreeNode tmp = null;

    public TreeNode increasingBST(TreeNode root) {
        build(root);
        return node;
    }

    public void build(TreeNode root){
        if (root.left==null&&root.right==null){
            if (node==null){
                node = root;
                tmp = node;
                return;
            }
        }
        if (root.left != null) {
            build(root.left);
        }
        if (node==null){
            node = root;
            tmp = node;
        }else {
            tmp.right = new TreeNode(root.val);
            tmp = tmp.right;
        }
        if (root.right != null){
            build(root.right);
        }
    }


    public static void main(String[] args) {
        LeetCode897 l = new LeetCode897();
        TreeNode node = new TreeNode(106);
        TreeNode node1 = new TreeNode(783);
        node.right = node1;
        l.increasingBST(node);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

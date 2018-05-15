package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Date: Created in 下午9:14 2018/5/11
 * @Modified By:
 */
public class LeetCode104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max=0;

    public int maxDepth(TreeNode root) {
        check(root,0);
        return max;
    }

    public void check(TreeNode node,int height){
        if (node==null){
            max=Math.max(max,height);
            return;
        }
        check(node.left,height+1);
        check(node.right,height+1);
    }
}

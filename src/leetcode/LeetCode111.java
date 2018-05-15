package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * @Date: Created in 下午9:20 2018/5/11
 * @Modified By:
 */
public class LeetCode111 {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    int min=0;

    public int minDepth(TreeNode root) {
        check(root,1);
        return min;
    }

    public void check(TreeNode node,int height){
        if (node==null){
            return;
        }
        if (node.left==null&&node.right==null){
            min=(min==-1?height:Math.min(min,height));
            return;
        }
        if (node.left!=null) {
            check(node.left, height + 1);
        }
        if (node.right!=null) {
            check(node.right, height + 1);
        }
    }
}

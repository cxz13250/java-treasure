package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不需要经过根节点。
 * @Date: Created in 下午8:15 2018/5/23
 * @Modified By:
 */
public class LeetCode124 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        check(root);
        return result;
    }

    public int check(TreeNode root){
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            result=Math.max(result,root.val);
            return root.val;
        }else {
            int right=check(root.right);
            int left=check(root.left);
            int temp=Math.max(right+root.val,Math.max(root.val,left+root.val));
            result=Math.max(result,Math.max(temp,right+root.val+left));
            return temp;
        }
    }

    public static void main(String[] args) {
        LeetCode124 l=new LeetCode124();
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        System.out.println(l.maxPathSum(node));
    }
}

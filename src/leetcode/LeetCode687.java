package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * @Date: Created in 下午5:54 2018/5/1
 * @Modified By:
 */
public class LeetCode687 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int max;
    public int longestUnivaluePath(TreeNode root) {
        if (root==null){
            return 0;
        }
        checkPath(root);
        return max;
    }

    public int checkPath(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=0;
        int right=0;
        if(node.left!=null){
            left=checkPath(node.left);
        }
        if(node.right!=null){
            right=checkPath(node.right);
        }
        if(node.left==null&&node.right==null){
            return 0;
        }else if(node.left==null){
            if(node.val==node.right.val){
                int temp=right+1;
                max=Math.max(temp,max);
                return temp;
            }else {
                return 0;
            }
        }else if(node.right==null){
            if(node.val==node.left.val){
                int temp=left+1;
                max=Math.max(temp,max);
                return temp;
            }else {
                return 0;
            }
        }else {
            if (node.val != node.left.val && node.val != node.right.val){
                return 0;
            }else if(node.val != node.left.val){
                int temp=right+1;
                max=Math.max(temp,max);
                return temp;
            }else if(node.val != node.right.val){
                int temp=left+1;
                max=Math.max(temp,max);
                return temp;
            }else {
                int temp=left+right+2;
                max=Math.max(temp,max);
                return Math.max(left,right)+1;
            }
        }
    }

    public static void main(String[] args) {
    }
}

package leetcode;

/**
 * @Author ROKG
 * @Description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * @Date: Created in 下午1:20 2018/4/22
 * @Modified By:
 */
public class LeetCode543 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 0;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);

        int diameterLeft=diameterOfBinaryTree(root.left);
        int diameterRight=diameterOfBinaryTree(root.right);
        return Math.max(left+right,Math.max(diameterLeft,diameterRight));
    }

    public int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }

    public static void main(String[] args) {

    }
}

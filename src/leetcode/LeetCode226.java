package leetcode;

/**
 * @Author ROKG
 * @Description 翻转一棵二叉树。
 * @Date: Created in 下午8:33 2018/4/27
 * @Modified By:
 */
public class LeetCode226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {

    }
}

package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:49 2018/4/26
 * @Modified By:
 */
public class LeetCode110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return false;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if(!(Math.abs(left-right)<=1)){
            return false;
        }else {
            boolean leftValid=true;
            boolean rightValid=true;
            if(root.left!=null){
                leftValid=isBalanced(root.left);
            }
            if(root.right!=null){
                rightValid=isBalanced(root.right);
            }
            return leftValid&rightValid;
        }
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

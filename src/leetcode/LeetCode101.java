package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 * @Date: Created in 下午10:40 2018/5/11
 * @Modified By:
 */
public class LeetCode101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode t1,TreeNode t2){
        if (t1==null&&t2==null){
            return true;
        }else if(t1!=null&&t2!=null&&t1.val==t2.val){
            return check(t1.left,t2.right)&&check(t1.right,t2.left);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}

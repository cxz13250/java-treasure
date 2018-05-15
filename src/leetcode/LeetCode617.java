package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * @Date: Created in 下午11:59 2018/5/10
 * @Modified By:
 */
public class LeetCode617 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        t1=check(null,t1,null,t2);
        return t1;
    }

    public TreeNode check(TreeNode parent1, TreeNode t1,TreeNode parent2, TreeNode t2){
        if (t1!=null&&t2!=null){
            t1.val+=t2.val;
            t1=check(t1,t1.left,t2,t2.left);
            t1=check(t1,t1.right,t2,t2.right);
        }else if(t1==null&&t2!=null){
            if (parent1==null){
                return t2;
            }else {
                if (parent2.left == t2) {
                    parent1.left = t2;
                } else {
                    parent1.right = t2;
                }
            }
        }
        return parent1==null?t1:parent1;
    }

    public static void main(String[] args) {
    }
}


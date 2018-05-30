package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @Date: Created in 下午2:27 2018/5/23
 * @Modified By:
 */
public class LeetCode112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    boolean result=false;

    public boolean hasPathSum(TreeNode root, int sum) {
        check(root,0,sum);
        return result;
    }

    public void check(TreeNode node,int count,int sum){
        if (node==null){
            return;
        }
        if (node.left==null&&node.right==null){
            count+=node.val;
            if (count==sum){
                result=true;
                return;
            }
        }
        if (node.left!=null){
            check(node.left,count+node.val,sum);
        }
        if (node.right!=null){
            check(node.right,count+node.val,sum);
        }
    }
}

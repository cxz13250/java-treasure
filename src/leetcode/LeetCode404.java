package leetcode;

/**
 * @Author ROKG
 * @Description 计算给定二叉树的所有左叶子之和。
 * @Date: Created in 下午3:16 2018/5/15
 * @Modified By:
 */
public class LeetCode404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result=0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root!=null){
            check(root,0);
        }
        return result;
    }

    // flag 0根节点，1左子树，2右子树
    public void check(TreeNode node,int flag){
        if (node.left==null&&node.right==null){
            if (flag==1){
                result+=node.val;
            }
        }else{
            if (node.left!=null){
                check(node.left,1);
            }
            if (node.right!=null){
                check(node.right,2);
            }
        }
    }
}

package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @Date: Created in 下午7:06 2018/5/8
 * @Modified By:
 */
public class LeetCode437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count=0;

    public int pathSum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        check(root,0,sum);
        if (root.left!=null){
            pathSum(root.left,sum);
        }
        if (root.right!=null){
            pathSum(root.right,sum);
        }
        return count;
    }

    public void check(TreeNode node,int sum,int target){
        if (node==null){
            return;
        }
        int temp=node.val+sum;
        if (target==temp){
            count++;
        }
        check(node.left,temp,target);
        check(node.right,temp,target);
    }

    public static void main(String[] args) {
    }
}

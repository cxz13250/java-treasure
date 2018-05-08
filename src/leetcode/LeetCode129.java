package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。例如，从根到叶子节点路径 1->2->3 代表数字 123。计算从根到叶子节点生成的所有数字之和。
 * @Date: Created in 下午4:39 2018/5/8
 * @Modified By:
 */
public class LeetCode129 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result=0;

    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        sum(root,0);
        return result;
    }

    public void sum(TreeNode node,int sum){
        sum=sum*10+node.val;
        if(node.left==null&&node.right==null){
            result+=sum;
        }else{
            if (node.left!=null) {
                sum(node.left, sum);
            }
            if (node.right!=null) {
                sum(node.right, sum);
            }
        }
    }
}

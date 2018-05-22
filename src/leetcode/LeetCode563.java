package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:28 2018/5/17
 * @Modified By:
 */
public class LeetCode563 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result=0;

    public int findTilt(TreeNode root) {
        getSum(root);
        return result;
    }

    public int getSum(TreeNode node){
        if (node==null){
            return 0;
        }else if (node.left==null&&node.right==null){
            return node.val;
        }else {
            int left=getSum(node.left);
            int right=getSum(node.right);
            result+=Math.abs(left-right);
            return left+right+node.val;
        }
    }
}

package leetcode;

/**
 * @Author ROKG
 * @Description 小偷又发现一个新的可行窃的地点。 这个地区只有一个入口，称为“根”。 除了根部之外，每栋房子有且只有一个父房子。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋形成了一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * @Date: Created in 下午4:14 2018/5/2
 * @Modified By: *
 */
public class LeetCode337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum1=robRoot(root);
        int sum2=robNotRoot(root);
        return Math.max(sum1,sum2);
    }

    public int robRoot(TreeNode node){
        if(node==null){
            return 0;
        }
        return node.val+robNotRoot(node.left)+robNotRoot(node.right);
    }

    public int robNotRoot(TreeNode node){
        if(node==null){
            return 0;
        }
        return rob(node.left)+rob(node.right);
    }

}

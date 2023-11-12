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

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 纯递归
     * 能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
     * 与 抢劫该节点的左子树+抢劫该节点的右子树的和  的最大值
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(rob(root.left) + rob(root.right), val + root.val);
    }

    /**
     * 递归+动态规划
     * 定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
     * 方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值
     * 状态转移方程：
     * 不抢当前节点的最大值=max(不抢左子节点最大值，抢左子节点最大值)+max(不抢右子节点最大值， 抢右子节点最大值)
     * 抢当前节点的最大值=不抢左子节点最大值+不抢右子节点最大值
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        int[] res=helper(root);
        return Math.max(res[0], res[1]);
    }


    public int[] helper(TreeNode r) {
        if (r == null) {
            return new int[2];
        }
        int[] left = helper(r.left);//对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额. left[0]则为不抢r.lrft可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
        int[] right = helper(r.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[1] = r.val + left[0] + right[0];//计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        return res;
    }
}

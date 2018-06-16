package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @Date: Created in 下午11:08 2018/6/1
 * @Modified By:
 */
public class LeetCode235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min=Math.min(p.val,q.val);
        int max=Math.max(p.val,q.val);
        TreeNode cur=root;
        while (!(cur.val>=min&&cur.val<=max)){
            if (cur.val>max){
                cur=cur.left;
            }else if (cur.val<min){
                cur=cur.right;
            }
        }
        return cur;
    }
}

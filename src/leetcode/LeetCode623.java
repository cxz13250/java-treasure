package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * @Date: Created in 下午1:01 2018/8/19
 * @Modified By:
 */
public class LeetCode623 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d==1){
            TreeNode node=new TreeNode(v);
            node.left=root;
            return node;
        }
        check(root,v,d,1);
        return root;
    }

    public void check(TreeNode node,int v,int d,int h){
        if (node==null){
            return;
        }
        if (h==d-1){
            TreeNode node1=new TreeNode(v);
            TreeNode node2=new TreeNode(v);
            node1.left=node.left;
            node2.right=node.right;
            node.left=node1;
            node.right=node2;
        }else {
            check(node.left,v,d,h+1);
            check(node.right,v,d,h+1);
        }
    }
}

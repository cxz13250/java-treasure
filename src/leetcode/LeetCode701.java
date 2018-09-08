package leetcode;

/**
 * @Author ROKG
 * @Description 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * @Date: Created in 上午10:34 2018/9/1
 * @Modified By:
 */
public class LeetCode701 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            root=new TreeNode(val);
            return root;
        }
        TreeNode pre=root;
        TreeNode cur=root;
        int flag=0;
        while (cur!=null){
            if (cur.val<val){
                pre=cur;
                flag=1;
                cur=cur.right;
            }else {
                flag=0;
                pre=cur;
                cur=cur.left;
            }
        }
        if (flag==0) { // 左孩子
            pre.left=new TreeNode(val);
        }else {
            pre.right=new TreeNode(val);
        }
        return root;
    }
}

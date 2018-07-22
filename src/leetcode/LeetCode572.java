package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * @Date: Created in 下午3:59 2018/7/22
 * @Modified By:
 */
public class LeetCode572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null){
            return false;
        }
        if (s.val==t.val){
            return isSame(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if (s==null&&t==null){
            return true;
        }
        if ((s==null&&t!=null) || (s!=null&&t==null) || s.val!=t.val){
            return false;
        }
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}

package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @Date: Created in 下午10:45 2018/5/14
 * @Modified By:
 */
public class LeetCode100 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null&&q!=null){
            if (p.val!=q.val){
                return false;
            }else {
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }
        }else if(p==null&&q==null){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode p=new TreeNode(5);
        TreeNode q=new TreeNode(5);
        TreeNode node1=new TreeNode(10);
        TreeNode node2=new TreeNode(10);
        TreeNode node3=new TreeNode(15);
        TreeNode node4=new TreeNode(15);
        node2.right=node4;
        p.left=node1;
        p.right=node3;
        q.left=node2;
        System.out.println(isSameTree(p,q));
    }

}

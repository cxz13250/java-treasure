package leetcode;

import java.util.TreeSet;

/**
 * @Author ROKG
 * @Description 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * @Date: Created in 下午3:46 2018/5/18
 * @Modified By:
 */
public class LeetCode671 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeSet<Integer> set=new TreeSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        check(root);
        if (set.size()<=1){
            return -1;
        }
        set.pollFirst();
        return set.pollFirst();
    }

    public void check(TreeNode node){
        if (node==null){
            return;
        }
        if (!set.contains(node.val)){
            set.add(node.val);
        }
        check(node.left);
        check(node.right);
    }

    public int findSecondMinimumValue2(TreeNode root){
        if (root==null){
            return -1;
        }
        if (root.left==null&root.right==null){
            return -1;
        }
        int left=root.left.val;
        int right=root.right.val;
        if (left==root.val){
            left=findSecondMinimumValue(root.left);
        }
        if (right==root.val){
            right=findSecondMinimumValue(root.right);
        }
        if (left!=-1&&right!=-1){
            return Math.min(left,right);
        }else if (left==-1){
            return right;
        }else {
            return left;
        }
    }
}

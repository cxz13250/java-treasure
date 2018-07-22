package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * @Date: Created in 上午11:08 2018/7/22
 * @Modified By:
 */
public class LeetCode653 {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return findNode(root,k,set);
    }

    public boolean findNode(TreeNode node,int k,Set<Integer> set){
        if (node==null){
            return false;
        }
        if (set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);
        return findNode(node.left,k, set) || findNode(node.right, k, set);
    }
}

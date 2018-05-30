package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回它的 前序 遍历。
 * @Date: Created in 下午8:33 2018/5/22
 * @Modified By:
 */
public class LeetCode144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        check(root,list);
        return list;
    }

    public void check(TreeNode node,List<Integer> list){
        if (node==null){
            return;
        }
        list.add(node.val);
        check(node.left,list);
        check(node.right,list);
    }
}

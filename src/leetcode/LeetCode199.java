package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 返回一个二叉树的右视图
 * @Date: Created in 下午1:47 2018/5/27
 * @Modified By:
 */
public class LeetCode199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        check(root, 0);
        return result;
    }

    public void check(TreeNode root, int i){
        if(root == null){
            return;
        }
        if(result.size()==i){
            result.add(root.val);
        }
        check(root.right, i+1);
        check(root.left, i+1);
    }

    // 层序遍历
    public List<Integer> rightSideView2(TreeNode root) {
        Queue<Integer> flag = new LinkedList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        flag.add(0);
        List<Integer> result = new ArrayList<>();
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
            int i = flag.poll();
            if(node.right != null) {
                treeNodes.add(node.right);
                flag.add(i+1);
            }
            if(node.left != null) {
                treeNodes.add(node.left);
                flag.add(i+1);
            }
            if (result.size()==i){
                result.add(node.val);
            }
        }
        return result;
    }
}

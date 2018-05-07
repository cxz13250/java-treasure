package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * @Date: Created in 下午11:15 2018/5/6
 * @Modified By:
 */
public class LeetCode107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        check(root,0);
        Collections.reverse(result);
        return result;
    }

    public void check(TreeNode node,int height){
        if (node==null){
            return;
        }
        if (height==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(height).add(node.val);
        check(node.left,height+1);
        check(node.right,height+1);
    }
}

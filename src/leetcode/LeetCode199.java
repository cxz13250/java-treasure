package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    Set<Integer> heights=new HashSet<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        check(list,root,0);
        return list;
    }

    public void check(List<Integer> result,TreeNode node, int height){
        if (node==null){
            return;
        }
        if (!heights.contains(height)){
            result.add(node.val);
            heights.add(height);
        }
        check(result,node.right,height+1);
        check(result,node.left,height+1);
    }
}

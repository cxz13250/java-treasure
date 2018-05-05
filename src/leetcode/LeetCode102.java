package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Date: Created in 下午8:08 2018/5/3
 * @Modified By:
 */
public class LeetCode102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        check(root,1);
        return result;
    }

    public void check(TreeNode node,int height){
        if(node==null){
            return;
        }else {
            if(result.size()<height){
                List<Integer> list=new ArrayList<>();
                list.add(node.val);
                result.add(list);
            }else {
                List<Integer> list=result.get(height-1);
                list.add(node.val);
            }
            check(node.left,height+1);
            check(node.right,height+1);
        }
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回其节点值的锯齿形层次遍历。即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 * @Date: Created in 下午9:43 2018/6/3
 * @Modified By:
 */
public class LeetCode103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Queue<TreeNode> queue=new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        check(false,result);
        return result;
    }

    public void check(boolean flag,List<List<Integer>> result){
        if (queue.isEmpty()){
            return;
        }
        List<TreeNode> nodes=new ArrayList<>();
        List<Integer> vals=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            vals.add(node.val);
            nodes.add(node);
        }
        result.add(vals);
        for (int i=nodes.size()-1;i>-1;i--){
            TreeNode temp=nodes.get(i);
            if (!flag) {
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
            }else {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        check(!flag,result);
    }
}

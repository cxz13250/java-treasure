package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * @Date: Created in 上午10:00 2018/5/18
 * @Modified By:
 */
public class LeetCode530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        int result=Integer.MAX_VALUE;
        check(list,root);
        for (int i=0;i<list.size()-1;i++){
            result=Math.min(result,Math.abs(list.get(i)-list.get(i+1)));
        }
        return result;
    }

    public void check(List<Integer> list, TreeNode node){
        if (node==null){
            return;
        }
        if (node.left!=null){
            check(list,node.left);
        }
        list.add(node.val);
        if (node.right!=null){
            check(list,node.right);
        }
    }
}

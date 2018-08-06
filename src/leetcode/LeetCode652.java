package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * @Date: Created in 2018/8/6
 * @Modified By: *
 */
public class LeetCode652 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //数组序列化，递归
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map=new HashMap<>();
        List<TreeNode> res=new ArrayList<>();
        check(root,map,res);
        return res;
    }

    public String check(TreeNode node, Map<String, Integer> map, List<TreeNode> list){
        if (node==null){
            return "#END";
        }
        String s= node.val+ "," + check(node.left,map,list) + "," + check(node.right,map,list);
        if (map.containsKey(s)&&map.get(s)==1){
            list.add(node);
        }
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }


}

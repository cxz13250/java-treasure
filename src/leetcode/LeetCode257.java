package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回从根节点到叶节点的所有路径。
 * @Date: Created in 下午5:07 2018/5/3
 * @Modified By:
 */
public class LeetCode257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<String> result=new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        findAllPath(root,"");
        return result;
    }

    public void findAllPath(TreeNode node,String str){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            result.add(str+node.val);
        }
        str+=(node.val+"->");
        if(node.left!=null){
            findAllPath(node.left,str);
        }
        if(node.right!=null){
            findAllPath(node.right,str);
        }
    }
}

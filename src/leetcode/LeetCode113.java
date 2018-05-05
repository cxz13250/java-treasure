package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @Date: Created in 下午4:42 2018/5/3
 * @Modified By:
 */
public class LeetCode113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list=new ArrayList<>();
        findAllPath(root,list,sum,0);
        return result;
    }

    public void findAllPath(TreeNode node,List<Integer> list, int sum,int count){
        if(node==null){
            return;
        }
        count+=node.val;
        list.add(node.val);
        if(node.left==null&&node.right==null){
            if(count==sum){
                result.add(new ArrayList<>(list));
            }
        }
        if(node.left!=null){
            findAllPath(node.left,list,sum,count+node.val);
        }
        if(node.right!=null){
            findAllPath(node.right,list,sum,count+node.val);
        }
        list.remove(list.size()-1);
    }
}

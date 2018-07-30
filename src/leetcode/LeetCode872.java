package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 考虑一个二叉树的所有叶子。这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。如果两个二叉树的叶值序列相同，我们就认为它们是 叶相似的。
 * @Date: Created in 2018/7/30
 * @Modified By:
 */
public class LeetCode872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        check(root1,list1);
        check(root2,list2);
        if (list1.size()!=list2.size()){
            return false;
        }
        for (int i=0;i<list1.size();i++){
            if (list1.get(i)!=list2.get(i)){
                return false;
            }
        }
        return true;
    }

    public void check(TreeNode root,List<Integer> list){
        if (root.left==null&&root.right==null){
            list.add(root.val);
        }else{
            if (root.left!=null){
                check(root.left,list);
            }
            if (root.right!=null){
                check(root.right,list);
            }
        }
    }

}

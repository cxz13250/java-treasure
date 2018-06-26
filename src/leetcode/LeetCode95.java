package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * @Date: Created in 下午2:03 2018/6/24
 * @Modified By: *
 */
public class LeetCode95 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n<0){
            return new ArrayList<>();
        }
        return generateSubTree(1,n);
    }

    public ArrayList<TreeNode> generateSubTree(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int root=start;root<end;root++){
            for (TreeNode left:generateSubTree(start,root-1)){
                for (TreeNode right:generateSubTree(root+1,end)){
                    TreeNode node=new TreeNode(root);
                    node.left=left;
                    node.right=right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}

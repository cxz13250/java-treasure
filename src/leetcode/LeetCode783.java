package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * @Date: Created in 2018/9/28
 * @Modified By:
 */
public class LeetCode783 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        midOrder(list, root);
        int pre=list.get(0);
        int res=Integer.MAX_VALUE;
        for (int i=1;i<list.size();i++){
            int tmp=list.get(i);
            res=Math.min(res, tmp-pre);
            pre=tmp;
        }
        return res;
    }

    public void midOrder(List<Integer> list,TreeNode node){
        if (node==null){
            return;
        }
        if (node.left!=null){
            midOrder(list, node.left);
        }
        list.add(node.val);
        if (node.right!=null){
            midOrder(list, node.right);
        }
    }
}

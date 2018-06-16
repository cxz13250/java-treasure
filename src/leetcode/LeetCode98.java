package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @Date: Created in 下午7:23 2018/6/4
 * @Modified By:
 */
public class LeetCode98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //获取中序遍历数组，检验是否有序
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        check(root,list);
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void check(TreeNode node,List<Integer> list){
        if (node==null){
            return;
        }
        check(node.left,list);
        list.add(node.val);
        check(node.right,list);
    }

    //递归检验
    public boolean isValidBST2(TreeNode root) {
        return check2(root,null,null);
    }

    public boolean check2(TreeNode node,Integer min,Integer max){
        if (node==null){
            return true;
        }
        if (min!=null){
            if (min>=node.val){
                return false;
            }
        }
        if (max!=null){
            if (max>node.val){
                return false;
            }
        }
        return check2(node.left,min,node.val)&&check2(node.right,node.val,max);
    }
}

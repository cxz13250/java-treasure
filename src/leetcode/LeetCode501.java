package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * @Date: Created in 上午12:20 2018/7/20
 * @Modified By:
 */
public class LeetCode501 {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    int max=0;
    List<Integer> list=new ArrayList<>();
    int cur=0;
    int count=0;
    public int[] findMode(TreeNode root) {
        findSameNode(root);
        int[] res=new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

    public void findSameNode(TreeNode node){
        if (node==null){
            return;
        }
        findSameNode(node.left);
        count++;
        if (node.val!=cur){
            count=1;
            cur=node.val;
        }
        if (count>max){
            max=count;
            list.clear();
            list.add(cur);
        }else if (count==max){
            list.add(cur);
        }
        findSameNode(node.right);
    }
}

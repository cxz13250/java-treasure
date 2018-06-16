package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第 k 个最小的元素。
 * @Date: Created in 下午3:42 2018/6/1
 * @Modified By:
 */
public class LeetCode230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root==null){
            return 0;
        }
        int temp=getNum(root.left);
        if (k==temp+1){
            return root.val;
        }else if (k<=temp){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right,k-temp-1);
        }
    }

    public int getNum(TreeNode node){
        if (node==null){
            return 0;
        }else {
            return 1+getNum(node.left)+getNum(node.right);
        }
    }

    //先序遍历找第k个值
    public int kthSmallest2(TreeNode root, int k) {
        findKth(root);

        return result.get(k - 1);
    }

    List<Integer> result = new ArrayList<>();
    public void findKth(TreeNode curNode){
        if (curNode == null){
            return;
        }
        else{
            findKth(curNode.left);
            result.add(curNode.val);
            findKth(curNode.right);
        }
    }
}

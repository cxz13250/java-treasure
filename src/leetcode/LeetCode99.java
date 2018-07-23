package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * @Date: Created in 2018/7/23
 * @Modified By:
 */
public class LeetCode99 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //O(n)空间复杂度
    public void recoverTree(TreeNode root) {
        TreeNode node1 = null, node2 = null;
        List<TreeNode> nodeList=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            if (!stack.isEmpty()){
                node=stack.pop();
                nodeList.add(node);
                node=node.right;
            }
        }
        boolean flag=true;
        for (int i=0;i<nodeList.size()-1;i++){
            if (nodeList.get(i).val>nodeList.get(i+1).val){
                if (flag){
                    node1=nodeList.get(i);
                    node2=nodeList.get(i+1);
                    flag=false;
                }else {
                    node2=nodeList.get(i+1);
                }
            }
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    TreeNode last=new TreeNode(Integer.MIN_VALUE);
    TreeNode large=null;
    TreeNode small=null;

    //O(1)空间复杂度
    public void recoverTree2(TreeNode root) {
        inOrder(root);
        int temp = large.val;
        large.val = small.val;
        small.val = temp;
    }

    public void inOrder(TreeNode node){
        if (node==null){
            return;
        }
        inOrder(node.left);
        if (large==null&&node.val<=last.val){
            large=node;
        }
        if (large!=null&&node.val<=last.val){
            small=node;
        }
        last=node;
        inOrder(node.right);
    }
}
